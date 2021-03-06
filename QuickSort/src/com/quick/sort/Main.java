package com.quick.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = 10;
        Integer[] list = new Integer[length];
        for (int i = 0; i < list.length; i++) {
            int num = Integer.parseInt(reader.readLine());
            list[i] = num;
        }

        QuickSort.quickSort(list, 0, length - 1);

        for (Integer number: list){
            System.out.println(number);
        }
    }
}
