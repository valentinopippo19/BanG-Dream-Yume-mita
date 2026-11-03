package com.waividol;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.sql.*;
import java.util.*;

public final class Database implements AutoCloseable {
    private final Connection connection;

    public Database() throws Exception {
        Path dir = Paths.get(System.getProperty("user.home"), ".waividol-universe");
        Files.createDirectories(dir);
        Path db = dir.resolve("waividol.sqlite");
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:" + db.toAbsolutePath());
        connection.setAutoCommit(true);
        try (Statement s = connection.createStatement()) { s.execute("PRAGMA foreign_keys = ON"); }
        initSchema();
    }

    private void initSchema() throws Exception {
        String sql;
        try (InputStream in = Database.class.getResourceAsStream("/db/schema.sql")) {
            if (in == null) throw new IllegalStateException("No se encontró schema.sql");
            sql = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        }
        for (String statement : sql.split(";")) {
            String trimmed = statement.trim();
            if (!trimmed.isEmpty()) try (Statement s = connection.createStatement()) { s.execute(trimmed); }
        }
    }

    public Connection connection() { return connection; }
    public void close() throws SQLException { connection.close(); }
}
