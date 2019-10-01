package com.codecool.filepartreader;

import java.io.*;

public class FilePartReader {
    String filePath = "invalid";
    Integer fromLine = -1;
    Integer toLine = -2;

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("Wrong arguments");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        FileInputStream fis = new FileInputStream(this.filePath);
        StringBuilder sb = new StringBuilder();

        int i;
        while ((i = fis.read()) != -1) {
            sb.append((char)i);
        }
        fis.close();

        return sb.toString();
    }

    public String readLines() throws IOException{
        String whole = this.read();

        String[] lines = whole.split(System.getProperty("line.separator"));

        StringBuilder sb = new StringBuilder();
        if (toLine == 1 && fromLine == 1) return sb.append(lines[0]).toString();

        for (int i = fromLine; i <= toLine; i++) {
            sb.append(lines[i]);
            if (i < toLine) {
                sb.append("\n");
            }
        }

        return sb.toString();

    }
}
