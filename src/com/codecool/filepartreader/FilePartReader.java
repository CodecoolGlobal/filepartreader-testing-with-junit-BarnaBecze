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
    }

    public String read() {
        try {
            FileInputStream fis = new FileInputStream(this.filePath);
            StringBuilder sb = new StringBuilder();

            int i;
            while ((i = fis.read())!= 0) {
                sb.append(i);
            }
            fis.close();

            return sb.toString();
        } catch (IOException e) {
            return "Error: " + e;
        }
    }

    public String readLines() {
        String whole = this.read();

        String[] lines = whole.split(System.getProperty("line.separator"));

        StringBuilder sb = new StringBuilder();

        for (int i = fromLine; i <= toLine; i++) {
            sb.append(lines[i]);
        }

        return sb.toString();

    }
}
