package org.imuniverse.fastslowpointers;

public class HappyNumber {

    public static void main(String[] args) {
        int[] a = {1, 7, 21, 28, 51};
        for (int i = 0; i < a.length; i++) {
            System.out.println("Input Number :" + a[i]);
            System.out.println("\tIs " + a[i] + " happy number : " + isHappyNumber(a[i]));
        }

    }

    private static boolean isHappyNumber(int n) {
        int slow = n;
        System.out.println("Slow pointer :" + slow);
        int fast = sumOfSquaredDigits(n);
        System.out.println("Fast pointer :" + fast);

        while(fast != 1 && fast != slow) {
            slow = sumOfSquaredDigits(slow);
            System.out.println("Slow pointer :" + slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
            System.out.println("Fast pointer :" + fast);
        }
        return fast == 1;
    }

    private static int sumOfSquaredDigits(int num) {
        int totalSum = 0;

        while(num != 0){
            int digit = num % 10;
            num = num / 10;
            totalSum += Math.pow(digit, 2);
        }
        return totalSum;
    }
}
