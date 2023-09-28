import org.imuniverse.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmTests {

    @Test
    public void given_String_reverse() {
        ReverseWords reverseWords = new ReverseWords();
        assertEquals("I ma !naMnorI", reverseWords.reverseString("I am IronMan!"));
    }

    @Test
    public void given_Int_Do_BinarySearch_Return_True() {
        boolean search = BinarySearch.search(new int[]{1, 2, 3, 4}, 4);
        assertTrue(search);
    }

    @Test
    public void given_Int_Do_BinarySearch_Return_False() {
        boolean search = BinarySearch.search(new int[]{1, 2, 3, 4}, 7);
        assertFalse(search);
    }

    @Test
    public void given_TwoIntArrays_AggregateAndFilter_EvenInt() {
        int[] arr1 = {1, 3, 5, 8};
        int[] arr2 = {2, 4, 10, 7};
        int[] aggregatedFilteredInts = AggregateFilter.aggregateFilter(arr1, arr2);
        assertArrayEquals(new int[]{8, 2, 4, 10},
                aggregatedFilteredInts);
    }

    @Test
    public void given_AnArray_ReturnReversed() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] reversed = ReverseArray.reverse(arr1);
        assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2, 1}, reversed);
    }

    @Test
    public void given_AnArray_rotateLeft() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] leftRotated = RotateArray.leftRotate(arr1);
        assertArrayEquals(new int[]{2, 3, 4, 5, 1}, leftRotated);
    }

    @Test
    public void given_AnArray_rotateRight() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] leftRotated = RotateArray.rightRotate(arr1);
        assertArrayEquals(new int[]{5, 1, 2, 3, 4}, leftRotated);
    }

    @Test
    public void given_LinkedList_removeKthNode() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("Kunal");
        customLinkedList.add("Salvi");
        customLinkedList.add("Manasi");
        customLinkedList.add("Riya");
        customLinkedList.displayContents();

        customLinkedList.deleteKthNode(3);
        customLinkedList.displayContents();

        //We can override the equals and hashcode to compare the contents of the object
        // for assertion purpose and sake of this test.
    }

    @Test
    public void given_Array_printNextGreaterForEachElement() {
        int[] arr = {9, 7, 2, 8, 17};
        NextGreaterElementArray.printNextGreaterElementInArray(arr);
    }

    @Test
    public void given_BinarySearchTree_search_returns_false() {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node<Integer> rootNode = new Node<>(1);
        binarySearchTree.setRoot(rootNode);
        binarySearchTree.insert(2);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(4);
        binarySearchTree.insert(11);
        binarySearchTree.insert(14);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);

        assertFalse(binarySearchTree.search(binarySearchTree.getRoot(),51));
    }

    @Test
    public void given_String_validateParenthesesSymmetry() {
        ValidateParentheses validator = new ValidateParentheses();
        String invalidSymmetry = "()[]}{";
        boolean isValid = validator.isValid(invalidSymmetry);
        assertFalse(isValid);

    }
}
