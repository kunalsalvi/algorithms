package org.imuniverse;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - i - 1];
        }
        System.out.println(Arrays.toString(reversed));
        return reversed;
    }
}
