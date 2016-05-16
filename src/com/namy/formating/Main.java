package com.namy.formating;


import com.namy.helper.*;
import com.namy.reading.*;
import com.namy.writing.*;


public class Main {
    
    public static void main(String[] args) {
        IReader read = new FileRead("test.txt");
        IWriter write = new FileWrite("result.txt");
        
        IHelper help = new Helper();
        Format format = new Format(help);
        
        format.format(read, write);
    }
    
}
