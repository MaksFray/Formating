package com.namy.writing;

public class StringWrite implements IWriter {

    private StringBuilder string;

    public StringWrite() {
        string = new StringBuilder();
    }

    @Override
    public void writeLine(String s) throws WriteException {
        string.append(s);
        System.out.print(string.toString());
        string.delete(0, string.length());
    }

    @Override
    public void close() throws WriteException {
        //System.out.println(string.toString());
    }

}
