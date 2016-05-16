package com.namy.formating;

import com.namy.reading.IReader;
import com.namy.writing.IWriter;


public interface IFormat {

    public void format(final IReader reader, final IWriter writer) throws FormatException;
}
