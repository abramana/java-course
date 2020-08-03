package com.javarush.task.task1326;

/* 
Sorting even numbers from file
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        ArrayList<Integer> numberArray = new ArrayList<>();
        while (bufferedReader.ready()) {
            int number = Integer.parseInt(bufferedReader.readLine());
            if (number % 2 == 0) {
                numberArray.add(number);
            }

        }
        Collections.sort(numberArray);
        for (Integer number: numberArray){
            System.out.println(number);
        }
        bufferedReader.close();
        reader.close();
    }
}
