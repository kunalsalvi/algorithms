package org.imuniverse.fastslowpointers;

import org.imuniverse.twopointers.LinkedList;
import org.imuniverse.twopointers.LinkedListNode;

public class PalindromeList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] nums = new int[]{5, 10, 15, 20, 15, 10, 5};
        list.createLinkedList(nums);
        System.out.println(palindrome(list.head));
    }

    static boolean palindrome(LinkedListNode head) {
        LinkedListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        LinkedListNode revertedNode = reverseLinkNodes(slow);
        boolean isPalindrome = compareTwoHalves(head,revertedNode);
        reverseLinkNodes(slow);
        return isPalindrome;
    }

    private static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
        while(firstHalf != null && secondHalf != null) {
            if(firstHalf.data != secondHalf.data) {
                return false;
            }else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }

    private static LinkedListNode reverseLinkNodes(LinkedListNode slow) {
        LinkedListNode prev = null;
        LinkedListNode next = null;
        LinkedListNode curr = slow;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
