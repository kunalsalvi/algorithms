package org.imuniverse;

public class BinarySearch {

    public static boolean search(int[] arr, int item) {
        int min = 0;
        int max = arr.length - 1;

        if(min == max) {
            return false;
        }

        while(min <= max) {
            int mid = (min + max) / 2;
            if(item == arr[mid]) {
                return true;
            } else if(item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
