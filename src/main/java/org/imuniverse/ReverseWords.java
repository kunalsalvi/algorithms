package org.imuniverse;

import java.util.Queue;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public String reverseString(String stringToReverse) {
        if(stringToReverse == null || stringToReverse.isEmpty()){
            return stringToReverse;
        }

        String[] splittedString = stringToReverse.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for(int i = 0; i < splittedString.length; i++) {
            StringBuilder word = new StringBuilder(splittedString[i]);
            reversedString.append(word.reverse());
            if(i != splittedString.length - 1){
                reversedString.append(" ");
            }
        }
        return reversedString.toString();

    }
}