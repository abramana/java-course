package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Number of letters
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Alphabet
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Input lines
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> mapAlphabet = new LinkedHashMap<>();
        for (Character letter: alphabet){
            mapAlphabet.put(letter, 0);
        }
        for (String word: list){
            for (Character symbol: word.toCharArray()){
                if (alphabet.contains(symbol)){
                    int count = mapAlphabet.get(symbol);
                    mapAlphabet.put(symbol, count + 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> letterAndCount: mapAlphabet.entrySet()){
            System.out.println(letterAndCount.getKey() + " " + letterAndCount.getValue());

        }
    }
}
