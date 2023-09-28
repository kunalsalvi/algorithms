package org.imuniverse.twopointers;

public class ValidPalindrome {
    public static void main(String[] args) {
        boolean isPalindrome = isPalindrome("RACECAR");
        System.out.println(isPalindrome);
    }

    public static boolean isPalindrome(String s) {
        char[] charsInString = s.toCharArray();
        int left = 0;
        int right = charsInString.length - 1;
        for (int i = 0; left < right; i++) {
            if(charsInString[left] == charsInString[right]) {
                left++;
                right--;
                i++;
            }else{
                return false;
            }
        }
        return true;
    }
}
