package org.imuniverse.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] slidingWindowMax = findMaxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(slidingWindowMax));
    }
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        List<Integer> maxValues = new ArrayList<>();
        for (int i = 0; i <= nums.length - w; i++) {
            Arrays.stream(Arrays.copyOfRange(nums, i, i + w))
                    .max()
                    .ifPresent(maxValues::add);
        }

        return maxValues.stream().mapToInt(Integer::intValue).toArray();
    }
}