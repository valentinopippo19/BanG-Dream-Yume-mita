package com.waividol;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.util.*;
public final class Json { public static final ObjectMapper M=new ObjectMapper(); public static Map<String,Object> map(InputStream in)throws IOException{return M.readValue(in,Map.class);} public static byte[] bytes(Object o)throws IOException{return M.writeValueAsBytes(o);} }
