package org.imuniverse;

import java.util.HashSet;

// Java program to find the longest substring
// with k unique characters in a given string
public class LongestSubStrWithKChars
 {

    // Function to calculate length of
    // longest substring with k characters
    static void longestKSubstr(String s, int k)
    {

        int n = s.length();
        int answer = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                HashSet<Character> distinct
                        = new HashSet<Character>();
                for (int x = i; x < j; x++) {
                    distinct.add(s.charAt(x));
                }
                if (distinct.size() == k) {
                    answer = Math.max(answer, j - i);
                }
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args)
    {
        String s = "aabacbebebe";
        int k = 3;

        // Function Call
        longestKSubstr(s, k);
    }
}

