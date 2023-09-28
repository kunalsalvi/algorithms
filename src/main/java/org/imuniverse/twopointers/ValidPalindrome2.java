package org.imuniverse.twopointers;

/**
 * This class represents the logic to see if given string can be
 * a possible palindrome just by removing a single letter from it
 */
public class ValidPalindrome2 {
    public static void main(String[] args) {
        String word = "abcdedadedecba";
        System.out.println(canBePalindrome(word));
    }

    private static boolean canBePalindrome(String s) {
        char[] letters = s.toCharArray();
        int left = 0;
        int right = letters.length - 1;
        int mismatch = 0;

        while (left < right) {
            if (letters[left] == letters[right]) {
                left++;
                right--;
            } else if (letters[++left] == letters[right] && mismatch < 1) {
                if (letters[--left] == letters[--right]) continue;
                left++;
                right--;
                mismatch++;
            } else if (letters[--left] == letters[--right] && mismatch < 1) {
                left++;
                right--;
                mismatch++;
            } else {
                return false;
            }
        }
        return true;
    }
}
