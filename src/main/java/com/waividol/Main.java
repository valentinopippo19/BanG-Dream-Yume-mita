package com.waividol;

import java.awt.Desktop;
import java.net.URI;

public final class Main {
    public static void main(String[] args) throws Exception {
        Database db=new Database();
        JsonCatalog catalog=new JsonCatalog();
        AuthService auth=new AuthService(db);
        WalletService wallet=new WalletService(db);
        QuizService quiz=new QuizService(catalog.questions(),wallet);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {try{db.close();}catch(Exception ignored){}}));
        new ApiServer(db,catalog,auth,wallet,quiz).start();
        // Open the local web app in the user's default browser after the HTTP server starts.
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(URI.create("http://127.0.0.1:8080"));
            }
        } catch (Exception ex) {
            System.out.println("No se pudo abrir el navegador automaticamente. Abrí http://127.0.0.1:8080 manualmente.");
        }
    }
}
