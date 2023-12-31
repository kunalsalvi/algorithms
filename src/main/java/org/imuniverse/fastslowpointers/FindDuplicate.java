package org.imuniverse.fastslowpointers;

public class FindDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    private static int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        System.out.println("Slow " + slow);
        System.out.println("Fast " + fast);
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(fast == slow) {
                System.out.println(fast + "\t" + slow);
                break;
            }
        }
        slow = nums[0];
        while(fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

}
