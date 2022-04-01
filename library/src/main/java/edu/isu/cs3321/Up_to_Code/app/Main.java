package edu.isu.cs3321.Up_to_Code.app;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String T = "";
        for(int i = 0,aux = 0;i<3;i++)
        {
            aux = '\u03B1' + i;
            T +=Character.toString((char)aux);
        }
        System.out.println(new String(T.getBytes(), StandardCharsets.UTF_8));
    }

}
