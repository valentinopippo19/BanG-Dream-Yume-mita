package com.waividol;

import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

public final class ApiServer {
    private final HttpServer server; private final Database db; private final JsonCatalog catalog; private final AuthService auth; private final WalletService wallet; private final QuizService quiz;
    public ApiServer(Database db,JsonCatalog catalog,AuthService auth,WalletService wallet,QuizService quiz)throws Exception{this.db=db;this.catalog=catalog;this.auth=auth;this.wallet=wallet;this.quiz=quiz;server=HttpServer.create(new InetSocketAddress("127.0.0.1",8080),0);server.createContext("/api/",this::api);server.createContext("/",this::staticFile);}
    public void start(){server.start();System.out.println("WaiVIdol Universe: http://127.0.0.1:8080");}
    private void api(com.sun.net.httpserver.HttpExchange e){try{String p=Http.path(e);String m=e.getRequestMethod();
        if(p.equals("/api/auth/register")){Http.method(e,"POST");Map<String,Object>b=Http.jsonBody(e);String t=auth.register((String)b.get("username"),(String)b.get("password"));Http.sessionCookie(e,t);Http.json(e,200,me(t));return;}
        if(p.equals("/api/auth/login")){Http.method(e,"POST");Map<String,Object>b=Http.jsonBody(e);String t=auth.login((String)b.get("username"),(String)b.get("password"));Http.sessionCookie(e,t);Http.json(e,200,me(t));return;}
        if(p.equals("/api/auth/logout")){Http.method(e,"POST");auth.logout(Http.cookie(e,"WAIVIDOL_SESSION"));Http.clearCookie(e);Http.json(e,200,Map.of("ok",true));return;}
        if(p.equals("/api/me")){Http.method(e,"GET");long u=auth.requireUser(Http.cookie(e,"WAIVIDOL_SESSION"));Http.json(e,200,me(Http.cookie(e,"WAIVIDOL_SESSION")));return;}
        if(p.equals("/api/characters")){Http.method(e,"GET");Http.json(e,200,catalog.characters());return;}
        if(p.startsWith("/api/characters/")&&m.equalsIgnoreCase("GET")){long u=auth.requireUser(Http.cookie(e,"WAIVIDOL_SESSION"));String id=Http.segment(p,3);Character c=catalog.findCharacter(id);if(c==null){Http.text(e,404,"Personaje no encontrado");return;}Map<String,Object> out=new LinkedHashMap<>();out.put("character",c);out.put("unlocks",wallet.unlocks(u));Http.json(e,200,out);return;}
        if(p.matches("/api/characters/[^/]+/unlock")){Http.method(e,"POST");long u=auth.requireUser(Http.cookie(e,"WAIVIDOL_SESSION"));String id=Http.segment(p,3);Character c=catalog.findCharacter(id);if(c==null){Http.text(e,404,"Personaje no encontrado");return;}Map<String,Object>b=Http.jsonBody(e);String contentId=(String)b.get("contentId");Character.Unlock unlock=c.unlock().stream().filter(x->x.id().equals(contentId)).findFirst().orElse(null);if(unlock==null){Http.text(e,400,"Contenido inválido");return;}boolean ok=wallet.spend(u,contentId,id,unlock.cost(),unlock.title());Http.json(e,ok?200:409,Map.of("ok",ok,"balance",wallet.balance(u),"unlocks",wallet.unlocks(u)));return;}
        if(p.equals("/api/wallet")){Http.method(e,"GET");long u=auth.requireUser(Http.cookie(e,"WAIVIDOL_SESSION"));Http.json(e,200,Map.of("balance",wallet.balance(u),"history",wallet.history(u),"correctAnswers",wallet.correctCount(u),"unlocks",wallet.unlocks(u)));return;}
        if(p.equals("/api/quiz/next")){Http.method(e,"POST");String token=Http.cookie(e,"WAIVIDOL_SESSION");long u=auth.requireUser(token);Http.json(e,200,quiz.next(token,u));return;}
        if(p.equals("/api/quiz/answer")){Http.method(e,"POST");String token=Http.cookie(e,"WAIVIDOL_SESSION");long u=auth.requireUser(token);Map<String,Object>b=Http.jsonBody(e);Http.json(e,200,quiz.answer(token,u,(String)b.get("questionId"),b.get("option") instanceof Number n?n.intValue():null));return;}
        Http.text(e,404,"API no encontrada");
    }catch(SecurityException ex){try{Http.json(e,401,Map.of("error",ex.getMessage()));}catch(Exception ignored){}}catch(IllegalArgumentException ex){try{Http.json(e,400,Map.of("error",ex.getMessage()));}catch(Exception ignored){}}catch(Exception ex){ex.printStackTrace();try{Http.json(e,500,Map.of("error","Error interno del servidor"));}catch(Exception ignored){}}}
    private Map<String,Object> me(String token)throws Exception{long u=auth.requireUser(token);return Map.of("username",auth.username(u),"balance",wallet.balance(u),"correctAnswers",wallet.correctCount(u),"unlocks",wallet.unlocks(u));}
    private void staticFile(HttpExchange e){try{String path=Http.path(e);if(path.equals("/"))path="/index.html";if(path.contains("..")){Http.text(e,403,"Forbidden");return;}InputStream in=ApiServer.class.getResourceAsStream("/static"+path);if(in==null){Http.text(e,404,"No encontrado");return;}byte[] data=in.readAllBytes();e.getResponseHeaders().set("Content-Type",mime(path));e.getResponseHeaders().set("Cache-Control","no-cache");e.sendResponseHeaders(200,data.length);try(OutputStream out=e.getResponseBody()){out.write(data);}}catch(Exception ex){try{Http.text(e,500,"Error");}catch(Exception ignored){}}}
    private String mime(String p){String l=p.toLowerCase();if(l.endsWith(".html"))return"text/html; charset=UTF-8";if(l.endsWith(".css"))return"text/css; charset=UTF-8";if(l.endsWith(".js"))return"application/javascript; charset=UTF-8";if(l.endsWith(".json"))return"application/json; charset=UTF-8";if(l.endsWith(".jpg")||l.endsWith(".jpeg"))return"image/jpeg";if(l.endsWith(".png"))return"image/png";if(l.endsWith(".mp4"))return"video/mp4";if(l.endsWith(".webm"))return"video/webm";return"application/octet-stream";}
}
