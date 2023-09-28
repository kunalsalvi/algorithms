package org.imuniverse.twopointers;

import java.util.Arrays;

public class ReverseWordsString {

    public static void main(String[] args) {
        String sentence = "Hello     love you all my friends!";
        String reversed = reverseWords(sentence);
        System.out.println(reversed);
    }

    private static String reverseWords(String sentence) {
        char[] charArray = sentence.replaceAll("\\s+", " ").trim().toCharArray();
        int start = 0;
        int end = 0;
        reverseString(charArray, 0, charArray.length-1);

        while (start < charArray.length) {
            while(end < charArray.length && charArray[end] != ' ') {
                end++;
            }
            reverseString(charArray, start, end-1);
            start = end+1;
            ++end;
        }
        System.out.println(Arrays.toString(charArray));
        return String.valueOf(charArray);
    }

    private static void reverseString(char[] charArray, int left, int right) {
        while(left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
    }
}
