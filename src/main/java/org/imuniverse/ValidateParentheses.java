package org.imuniverse;

import java.util.Stack;

public class ValidateParentheses {

    public boolean isValid(String s) {
        if(s == null || s.length() < 2) {
            return false;
        }

        if(s.length()%2 != 0) {
            return false;
        }
        char[] charArray = s.toCharArray();

        Stack<Character> pairs = new Stack<>();
        pairs.push(charArray[0]);
        for (int i = 1; i < charArray.length; i++) {
            if(pairs.isEmpty()) {
                break;
            }
            Character popped = pairs.pop();
            if(popped.equals('(') && charArray[i] == ')') {
                System.out.println("matched " + "(");
            } else if (popped.equals('[') && charArray[i] == ']') {
                System.out.println("matched " + "[");
            }
            else if (popped.equals('{') && charArray[i] == '}') {
                System.out.println("matched " + "{");
            } else {
                pairs.push(popped);
                if(charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                    pairs.push(charArray[i]);
                }
            }

            if(pairs.isEmpty() && i+1 < charArray.length) {
                char next = charArray[i+1];
                if( next == '(' || next == '[' || next == '{') {
                    pairs.push(next);
                    if(i+2 < charArray.length) {
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        
        return pairs.isEmpty();
    }
}
