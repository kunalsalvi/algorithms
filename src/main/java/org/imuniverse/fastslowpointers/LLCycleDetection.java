package org.imuniverse.fastslowpointers;

import org.imuniverse.twopointers.LinkedList;
import org.imuniverse.twopointers.LinkedListNode;

public class LLCycleDetection {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] nums = {1,2,3,4,5,6,2};
        list.createLinkedList(nums);
        LinkedListNode lastNode = null;
        LinkedListNode head = list.head;

        while(head.next != null) {
            head = head.next;
            lastNode = head;
        }

        lastNode.next = list.head.next.next.next;

        //System.out.println(lastNode.next.data);
        System.out.println(detectCycle(list.head));
    }

    private static boolean detectCycle(LinkedListNode head) {
        if(head == null) {
            return false;
        }

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) return true;

        }
        return false;
    }
}
