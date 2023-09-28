package org.imuniverse;

public class RotateArray {

    public static int[] leftRotate(int[] arr1){
        if(arr1 == null  || arr1.length == 1){
            return arr1;
        }
        int impactPosVal = arr1[0];
        for(int i = 0; i < arr1.length; i++) {
            if(i+1 == arr1.length) {
                arr1[i] = impactPosVal;
                break;
            }
            arr1[i] = arr1[i+1];
        }
        return arr1;
    }

    public static int[] rightRotate(int[] arr1){
        if(arr1 == null  || arr1.length == 1){
            return arr1;
        }
        int impactPosVal = arr1[0];
        int tempPosVal;
        for(int i = 0; i < arr1.length; i++) {
            if(i == 0) {
                arr1[i] = arr1[arr1.length - 1];
            } else {
                tempPosVal = arr1[i];
                arr1[i] = impactPosVal;
                impactPosVal = tempPosVal;
            }
        }
        return arr1;
    }
}
