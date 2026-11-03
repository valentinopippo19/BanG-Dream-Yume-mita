package com.waividol;

import java.sql.*;
import java.util.*;

public final class WalletService {
    private final Database db;
    public WalletService(Database db) { this.db=db; }

    public int balance(long userId) throws SQLException { try(PreparedStatement p=db.connection().prepareStatement("SELECT wvid FROM wallets WHERE user_id=?")){p.setLong(1,userId);try(ResultSet r=p.executeQuery()){return r.next()?r.getInt(1):0;}} }
    public List<Map<String,Object>> history(long userId) throws SQLException { List<Map<String,Object>> out=new ArrayList<>(); try(PreparedStatement p=db.connection().prepareStatement("SELECT amount,reason,created_at FROM transactions WHERE user_id=? ORDER BY id DESC LIMIT 50")){p.setLong(1,userId);try(ResultSet r=p.executeQuery()){while(r.next()){Map<String,Object> m=new LinkedHashMap<>();m.put("amount",r.getInt(1));m.put("reason",r.getString(2));m.put("date",r.getString(3));out.add(m);}}} return out; }

    public synchronized boolean spend(long userId, String contentId, String characterId, int cost, String title) throws SQLException {
        if (cost <= 0) throw new IllegalArgumentException("Costo inválido.");
        db.connection().setAutoCommit(false);
        try {
            try(PreparedStatement p=db.connection().prepareStatement("SELECT 1 FROM unlocks WHERE user_id=? AND content_id=?")){p.setLong(1,userId);p.setString(2,contentId);try(ResultSet r=p.executeQuery()){if(r.next()){db.connection().rollback();return false;}}}
            int current=balance(userId); if(current<cost){db.connection().rollback();return false;}
            try(PreparedStatement p=db.connection().prepareStatement("UPDATE wallets SET wvid=wvid-? WHERE user_id=?")){p.setInt(1,cost);p.setLong(2,userId);p.executeUpdate();}
            try(PreparedStatement p=db.connection().prepareStatement("INSERT INTO unlocks(user_id,content_id,character_id,cost) VALUES(?,?,?,?)")){p.setLong(1,userId);p.setString(2,contentId);p.setString(3,characterId);p.setInt(4,cost);p.executeUpdate();}
            try(PreparedStatement p=db.connection().prepareStatement("INSERT INTO transactions(user_id,amount,reason) VALUES(?,?,?)")){p.setLong(1,userId);p.setInt(2,-cost);p.setString(3,"Desbloqueo: "+title);p.executeUpdate();}
            db.connection().commit(); return true;
        } catch(Exception e){db.connection().rollback();throw e;} finally {db.connection().setAutoCommit(true);}
    }

    public Set<String> unlocks(long userId) throws SQLException { Set<String> s=new HashSet<>();try(PreparedStatement p=db.connection().prepareStatement("SELECT content_id FROM unlocks WHERE user_id=?")){p.setLong(1,userId);try(ResultSet r=p.executeQuery()){while(r.next())s.add(r.getString(1));}}return s; }
    public boolean hasUnlock(long userId,String contentId) throws SQLException { try(PreparedStatement p=db.connection().prepareStatement("SELECT 1 FROM unlocks WHERE user_id=? AND content_id=?")){p.setLong(1,userId);p.setString(2,contentId);try(ResultSet r=p.executeQuery()){return r.next();}} }

    public void recordQuiz(long userId,String questionId,boolean correct,boolean timedOut,long elapsedMs) throws SQLException {
        db.connection().setAutoCommit(false);
        try {
            try(PreparedStatement p=db.connection().prepareStatement("INSERT INTO quiz_attempts(user_id,question_id,correct,timed_out,elapsed_ms) VALUES(?,?,?,?,?)")){p.setLong(1,userId);p.setString(2,questionId);p.setInt(3,correct?1:0);p.setInt(4,timedOut?1:0);p.setLong(5,elapsedMs);p.executeUpdate();}
            if(correct){try(PreparedStatement p=db.connection().prepareStatement("UPDATE wallets SET wvid=wvid+1 WHERE user_id=?")){p.setLong(1,userId);p.executeUpdate();}try(PreparedStatement p=db.connection().prepareStatement("INSERT INTO transactions(user_id,amount,reason) VALUES(?,?,?)")){p.setLong(1,userId);p.setInt(2,1);p.setString(3,"Recompensa quiz: +1 WVID");p.executeUpdate();}}
            db.connection().commit();
        } catch(Exception e){db.connection().rollback();throw e;} finally {db.connection().setAutoCommit(true);}
    }

    public int correctCount(long userId) throws SQLException {try(PreparedStatement p=db.connection().prepareStatement("SELECT COUNT(*) FROM quiz_attempts WHERE user_id=? AND correct=1")){p.setLong(1,userId);try(ResultSet r=p.executeQuery()){r.next();return r.getInt(1);}}}
}
