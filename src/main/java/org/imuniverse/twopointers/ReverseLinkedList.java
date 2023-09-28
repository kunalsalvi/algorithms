package org.imuniverse.twopointers;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] nums = {69, 8, 49, 106, 116, 112};
        linkedList.createLinkedList(nums);
        LinkedListNode linkedListNode = removeNthLastNode(linkedList.head, 6);
        System.out.println(linkedListNode.data);
    }
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode left = head;
        LinkedListNode right = head;
        for (int i = 0; i < n; i++) {
            if(right == null) {
                throw new IllegalArgumentException("n value provided is incorrect");
            }
            right = right.next;

        }

        while(right != null && right.next != null) {
            left = left.next;
            right = right.next;
        }
        if(right == null) {
            head = left.next;
            return head;
        }

        if (left.next == null) throw new AssertionError();
        left.next = left.next.next;


        return head;
    }
}