package org.imuniverse.fastslowpointers;

public class CircularArrayLoop{
    public static void main(String[] args) {
        int[] nums = {3, 3, 1, -1, 2};
        System.out.println(circularArrayLoop(nums));
    }
    public static boolean circularArrayLoop(int[] nums) {

        int size = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while(true){
                slow = detectNextPosition(slow, nums[slow], size);
                if(isNotCyclic(slow, forward, nums)){
                    break;
                }

                fast = detectNextPosition(fast, nums[fast], size);
                if(isNotCyclic(fast, forward, nums)){
                    break;
                }
                fast = detectNextPosition(fast, nums[fast], size);
                if(isNotCyclic(fast, forward, nums)){
                    break;
                }

                if(fast == slow) return true;
            }
        }
        return false;
    }

    private static boolean isNotCyclic(int pointer, boolean prevDirection, int[] nums) {
        return nums[pointer] >= 0 != prevDirection || Math.abs(nums[pointer] % nums.length) == 0;
    }

    private static int detectNextPosition(int pointer, int value, int arraySize) {
        pointer = (pointer + value) % arraySize;
        if(pointer < 0){
            pointer = pointer + arraySize;
        }
        return pointer;
    }
}
