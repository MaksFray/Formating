package com.namy.formating;


import com.namy.reading.*;
import com.namy.writing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Main {
    
    public static void main(String[] args) throws ReadException, WriteException, FormatException {
        FileInputStream fis;
        Properties property = new Properties();
        String counter ="";
        String indent = "";
        try {
            fis = new FileInputStream("src/com/namy/formating/config.properties");
            property.load(fis);       
            counter = property.getProperty("counter");
            indent = property.getProperty("indent");
            indent = indent.replaceAll("\"", "");
            fis.close();
        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
        
        
        IReader read = new FileRead("test.txt");
        IWriter write = new FileWrite("result.txt");
        
        //IReader read = new StringRead("JSONObject reader;try{reader = new JSONObject(response.toString()); try{magic.fn;}}catch(JSONException e) {e.printStackTrace(); try {}");
        //IWriter write = new StringWrite();
        
        IHelper help = new Helper(indent,counter);
        Format format = new Format(help);
        
        format.format(read, write);
                
    }
    
}
