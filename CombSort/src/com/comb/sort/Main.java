package com.comb.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] list = new String[10];
        for (int i = 0; i < list.length; i++){
            String str = reader.readLine();
            list[i] = str;
        }
        CombSort.sort(list);
        for (String str: list){
            System.out.println(str);
        }
    }
}
