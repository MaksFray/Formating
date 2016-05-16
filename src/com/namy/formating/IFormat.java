package com.namy.formating;

import com.namy.reading.IReader;
import com.namy.reading.ReadException;
import com.namy.writing.IWriter;
import com.namy.writing.WriteException;


public interface IFormat {
    public void format(final IReader reader, final IWriter writer) throws ReadException, WriteException, FormatException;
}
