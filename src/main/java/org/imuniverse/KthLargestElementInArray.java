package org.imuniverse;

import java.util.Arrays;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int i = quickSelect(Arrays.copyOf(nums, nums.length), 0, nums.length - 1, k);
        int[] sortArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortArray);
        int j = sortArray[k];
        System.out.println("Quickselect vs Sorting " + (i == j));
        return j;
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int idx = low, pivot = high;

        for (int i = low; i < high; i++) {
            if (nums[i] <= nums[pivot]) {
                swap(nums, i, idx);
                ++idx;
            }
        }

        System.out.println("Array " + Arrays.toString(nums));
        System.out.println("IDX " + idx);
        System.out.println("PIVOT " + pivot);

        swap(nums, idx, pivot);

        System.out.println("Array " + Arrays.toString(nums));


        if (idx == k) {
            return nums[idx];
        } else if (idx < k) {
            return quickSelect(nums, idx + 1, high, k);
        } else {
            return quickSelect(nums, low, idx - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int[] array = new int[]{3,2,1,5,6,4};
        int k = 3;
        System.out.println(Arrays.toString(array));
        int kthLargest = kthLargestElementInArray.findKthLargest(array, k);
        System.out.println(kthLargest);
    }

}
