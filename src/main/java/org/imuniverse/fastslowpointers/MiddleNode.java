package org.imuniverse.fastslowpointers;

import org.imuniverse.twopointers.LinkedList;
import org.imuniverse.twopointers.LinkedListNode;

public class MiddleNode{
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] nums = {1,3,4,5,7,8};
        list.createLinkedList(nums);
        System.out.println(middleNode(list.head).data);
    }
    public static LinkedListNode middleNode(LinkedListNode head) {

        LinkedListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
