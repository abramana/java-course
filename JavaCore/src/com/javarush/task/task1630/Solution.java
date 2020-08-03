package com.javarush.task.task1630;

/*
Sequential file output
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface{

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        public String fullFileName;
        public String content;

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            if (content == null){
                return "";
            }
            return content;
        }

        @Override
        public void run() {
            try {
                File file = new File(fullFileName);
                BufferedReader br = new BufferedReader(new FileReader(file));
                StringBuilder b = new StringBuilder();
                String st;
                while ((st = br.readLine()) != null) {
                    b.append(st)
                            .append(" ");
                }
                content = b.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
