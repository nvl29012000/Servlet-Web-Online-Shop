package com.locnv.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;

public class HttpUtil {
    public static <T> T jsonToModel(BufferedReader reader, Class<T> classt){
        try{
            String line;
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null){
                sb.append(line);
            }
            return new ObjectMapper().readValue(sb.toString(), classt);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
