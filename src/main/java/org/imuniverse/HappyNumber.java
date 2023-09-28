package org.imuniverse;

public class HappyNumber {

    public static void main(String[] args) {
        int[] a = {1,5,19,25,7};
        for (int i = 0; i < a.length; i++) {
            System.out.println(i+1 + "." + "\tInput Number :" + a[i]);
            System.out.println("\t Sum of squared digits: " + sumOfSquaredDigits(a[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

    private static int sumOfSquaredDigits(int num) {

        return 0;
    }
}
