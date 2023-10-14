package org.imuniverse.slidingwindow;

import java.util.Arrays;

public class MinimumWindowSubsequence {

    public static void main(String[] args) {
        String source = "HelloWeldlomeednnlo";
        String target = "eo";

        System.out.println(minWindow(source, target));
    }

    private static String minWindow(String source, String target) {
        if(source.length() < target.length())
            return "";

        String minWindow = "";
        char[] charsInSource = source.toCharArray();
        char[] charsInTarget = target.toCharArray();
        // 1. Check if the target string characters existence in source string in same order
        // 2. Identify the windows in the source string with target string chars
        // 3. Return the smallest window found in the identified list of windows

        for (int i = 0; i <= charsInSource.length - charsInTarget.length; i++) {

            int[] windowIndices = charsExistInOrder(Arrays.copyOfRange(source.toCharArray(),i,source.length()), charsInTarget);
            if(windowIndices.length == 0)
                continue;

            String windowString = source.subSequence(windowIndices[0], windowIndices[1]).toString();
            if(i == 0) {
                minWindow = windowString;
            }
            if(windowString.length() < minWindow.length()) {
                minWindow = windowString;
            }

        }

        return minWindow;
    }

    private static int[] charsExistInOrder(char[] charsInSource, char[] charsInTarget) {
        int j = 0;
        int startWindow = 0;
        int endWindow = -1;

        for (int i = 0; i < charsInSource.length; i++) {
            if(charsInSource[i] == charsInSource[j]) {
                j++;
                if(!(startWindow > 0)) startWindow = i;
            }
            if(j == charsInTarget.length - 1) {
                endWindow = i;
                break;
            }
        }
        if(endWindow == -1){
            return new int[]{};
        } else {
            return new int[]{startWindow, endWindow};
        }
    }
}
