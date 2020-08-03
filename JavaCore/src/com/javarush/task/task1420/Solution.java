package com.javarush.task.task1420;

/* 
Greatest common divisor
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());
        System.out.println(gcd(firstNumber, secondNumber));
        }
    public static int gcd(int firstNumber, int secondNumber) throws Exception {
        if (firstNumber <= 0 || secondNumber <= 0) throw new Exception();
        while(firstNumber != secondNumber){
            if (firstNumber > secondNumber){
                firstNumber = firstNumber - secondNumber;
            } else {
                secondNumber = secondNumber - firstNumber;
            }
        }
        return firstNumber;
    }
}

