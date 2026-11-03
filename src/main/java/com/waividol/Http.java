package com.waividol;

import com.sun.net.httpserver.HttpExchange;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class Http {
    public static String body(HttpExchange e) throws IOException { return new String(e.getRequestBody().readAllBytes(), StandardCharsets.UTF_8); }
    public static Map<String,Object> jsonBody(HttpExchange e) throws IOException { return Json.M.readValue(body(e), Map.class); }
    public static void json(HttpExchange e,int status,Object obj)throws IOException{byte[] b=Json.bytes(obj);e.getResponseHeaders().set("Content-Type","application/json; charset=UTF-8");e.getResponseHeaders().set("Cache-Control","no-store");e.sendResponseHeaders(status,b.length);try(OutputStream out=e.getResponseBody()){out.write(b);}}
    public static void text(HttpExchange e,int status,String s)throws IOException{byte[] b=s.getBytes(StandardCharsets.UTF_8);e.getResponseHeaders().set("Content-Type","text/plain; charset=UTF-8");e.sendResponseHeaders(status,b.length);try(OutputStream out=e.getResponseBody()){out.write(b);}}
    public static String cookie(HttpExchange e,String name){String all=e.getRequestHeaders().getFirst("Cookie");if(all==null)return null;for(String part:all.split(";")){String[] kv=part.trim().split("=",2);if(kv.length==2&&kv[0].equals(name))return kv[1];}return null;}
    public static void sessionCookie(HttpExchange e,String token){e.getResponseHeaders().add("Set-Cookie","WAIVIDOL_SESSION="+token+"; Path=/; HttpOnly; SameSite=Lax");}
    public static void clearCookie(HttpExchange e){e.getResponseHeaders().add("Set-Cookie","WAIVIDOL_SESSION=; Path=/; Max-Age=0; HttpOnly; SameSite=Lax");}
    public static String path(HttpExchange e){return e.getRequestURI().getPath();}
    public static String segment(String path,int index){String[] p=path.split("/");return p.length>index?p[index]:"";}
    public static void method(HttpExchange e,String expected)throws IOException{if(!e.getRequestMethod().equalsIgnoreCase(expected)){e.getResponseHeaders().set("Allow",expected);text(e,405,"Método no permitido");}}
}
