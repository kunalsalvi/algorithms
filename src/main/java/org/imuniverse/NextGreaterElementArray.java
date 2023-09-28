package org.imuniverse;

import java.util.Stack;

public class NextGreaterElementArray {

    public static void printNextGreaterElementInArray(int[] arr) {
        if(arr == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];

            if(!stack.isEmpty()){
                int popped = stack.pop();
                while(popped < next) {
                    System.out.println(popped + " --> " + next);
                    if(stack.isEmpty()){
                        break;
                    }
                    popped = stack.pop();
                }
                if(popped > next){
                    stack.push(popped);
                }
            }
            stack.push(next);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> -1" );
        }
    }
}
