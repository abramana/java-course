package com.javarush.task.task1527;

/* 
URL request parser - regexp
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();

        Pattern pattern = Pattern.compile("[?&][a-zA-Z0-9]+");
        Matcher matcher = pattern.matcher(url);

        ArrayList<String> matchedStrings = new ArrayList<>();

        while (matcher.find())
        {
            matchedStrings.add(matcher.group());
        }

        for (String parameters: matchedStrings){
            String s = parameters;
            if (parameters.contains("?")){
                s = parameters.replace("?", "");
            } else if (parameters.contains("&")){
                s = parameters.replace("&", " ");
            }
            System.out.print(s);
        }
        System.out.println();

        if (url.contains("obj")){
            Pattern newPattern = Pattern.compile("obj=[^\\&]+");
            Matcher newMatcher = newPattern.matcher(url);

            ArrayList<String> newMatchedStrings = new ArrayList<>();

            while (newMatcher.find())
            {
                newMatchedStrings.add(newMatcher.group());
            }

            for (int i = 0; i < newMatchedStrings.size(); i++){
                String s = newMatchedStrings.get(i).replace("obj=", "");
                try{
                    double d = Double.parseDouble(s);
                    alert(d);
                } catch (Exception e){
                    alert(s);
                }

            }

        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
