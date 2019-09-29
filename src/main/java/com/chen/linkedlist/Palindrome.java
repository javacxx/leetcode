package com.chen.linkedlist;

import java.util.Stack;

/**
 * @author CXX
 * @date 2019/9/29 15:05
 */
public class Palindrome {
    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add("A");
        singlyLinkedList.add("B");
        singlyLinkedList.add("E");
        singlyLinkedList.add("B");
        singlyLinkedList.add("A1");

        System.out.println(validatePalindrome(singlyLinkedList));
    }

    public static boolean validatePalindrome(SinglyLinkedList<String> singlyLinkedList) {
        int listSize = singlyLinkedList.getSize();

        int secondHalfBeginIndex;
        boolean oddFlag = true;
        if (listSize % 2 == 0) {
            oddFlag = false;
            secondHalfBeginIndex = listSize / 2;
        } else {
            secondHalfBeginIndex = listSize / 2 + 1;
        }



        int index = 0;
        Stack<String> stack = new Stack();
        do{
            if (oddFlag) {
                if (index < secondHalfBeginIndex-1) {
                    stack.add(singlyLinkedList.get(index));
                } else if( index == secondHalfBeginIndex-1) {
                } else if (!singlyLinkedList.get(index).equals(stack.pop())) {
                    return false;
                }
            } else {
                if (index < secondHalfBeginIndex) {
                    stack.add(singlyLinkedList.get(index));
                } else if (!singlyLinkedList.get(index).equals(stack.pop())) {
                    return false;
                }
            }
            index++;
        } while (index < listSize);
        return true;
    }

}
