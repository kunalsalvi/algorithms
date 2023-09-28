package org.imuniverse.twopointers;

import java.util.Arrays;

public class SumOfThree {
    public static void main(String[] args) {
        System.out.println(findSumOfThree(new int[]{1, 2, 4, 6, 8, 20},31));
    }

    private static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return true;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return false;
    }
}
