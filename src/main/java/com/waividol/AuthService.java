package com.waividol;

import java.security.*;
import java.security.spec.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public final class AuthService {
    private final Database db;
    private final Map<String, Long> sessions = new ConcurrentHashMap<>();

    public AuthService(Database db) { this.db = db; }

    public synchronized String register(String username, String password) throws Exception {
        username = cleanUsername(username);
        if (password == null || password.length() < 6) throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres.");
        byte[] salt = new byte[16]; SecureRandom.getInstanceStrong().nextBytes(salt);
        byte[] hash = hash(password.toCharArray(), salt);
        db.connection().setAutoCommit(false);
        try {
            long id;
            try (PreparedStatement p = db.connection().prepareStatement(
                    "INSERT INTO users(username,password_hash,password_salt) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                p.setString(1, username); p.setString(2, Base64.getEncoder().encodeToString(hash)); p.setString(3, Base64.getEncoder().encodeToString(salt)); p.executeUpdate();
                try (ResultSet rs = p.getGeneratedKeys()) { rs.next(); id = rs.getLong(1); }
            }
            try (PreparedStatement p = db.connection().prepareStatement("INSERT INTO wallets(user_id,wvid) VALUES(?,10)")) { p.setLong(1,id); p.executeUpdate(); }
            try (PreparedStatement p = db.connection().prepareStatement("INSERT INTO transactions(user_id,amount,reason) VALUES(?,?,?)")) { p.setLong(1,id); p.setInt(2,10); p.setString(3,"Saldo inicial de cuenta"); p.executeUpdate(); }
            db.connection().commit();
            return createSession(id);
        } catch (Exception e) { db.connection().rollback(); throw e; } finally { db.connection().setAutoCommit(true); }
    }

    public String login(String username, String password) throws Exception {
        if (username == null || password == null) throw new IllegalArgumentException("Usuario y contraseña son obligatorios.");
        try (PreparedStatement p = db.connection().prepareStatement("SELECT id,password_hash,password_salt FROM users WHERE username=?")) {
            p.setString(1, username.trim());
            try (ResultSet rs = p.executeQuery()) {
                if (!rs.next()) throw new SecurityException("Usuario o contraseña incorrectos.");
                byte[] salt = Base64.getDecoder().decode(rs.getString(3));
                byte[] expected = Base64.getDecoder().decode(rs.getString(2));
                if (!MessageDigest.isEqual(expected, hash(password.toCharArray(), salt))) throw new SecurityException("Usuario o contraseña incorrectos.");
                return createSession(rs.getLong(1));
            }
        }
    }

    public void logout(String token) { if (token != null) sessions.remove(token); }
    public long requireUser(String token) { Long id = token == null ? null : sessions.get(token); if (id == null) throw new SecurityException("Sesión no iniciada."); return id; }
    public String username(long id) throws SQLException { try (PreparedStatement p=db.connection().prepareStatement("SELECT username FROM users WHERE id=?")){p.setLong(1,id);try(ResultSet r=p.executeQuery()){return r.next()?r.getString(1):"";}} }
    public String createSession(long userId) { byte[] b=new byte[32]; new SecureRandom().nextBytes(b); String token=Base64.getUrlEncoder().withoutPadding().encodeToString(b); sessions.put(token,userId); return token; }

    private static String cleanUsername(String u) { if(u==null) throw new IllegalArgumentException("Ingresá un nombre de usuario."); u=u.trim(); if(!u.matches("[A-Za-z0-9_]{3,24}")) throw new IllegalArgumentException("El usuario debe tener 3-24 caracteres: letras, números o _. "); return u; }
    private static byte[] hash(char[] password, byte[] salt) throws Exception { PBEKeySpec spec=new PBEKeySpec(password,salt,120000,256); try { return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded(); } finally { spec.clearPassword(); } }
}
