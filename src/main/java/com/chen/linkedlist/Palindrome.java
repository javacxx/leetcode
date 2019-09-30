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

        System.out.println(validatePalindromeWithStack(singlyLinkedList));
    }


    public static boolean validatePalindromeReversed(SinglyLinkedList<String> singlyLinkedList) {
        int i = 0;
        int lastIndex = singlyLinkedList.getSize() - 1;
        do{
            if (!singlyLinkedList.get(i).equals(singlyLinkedList.get(lastIndex - i))) {
                return false;
            }
            i++;
        } while (2*i < lastIndex);
        return true;
    }

    public static boolean validatePalindromeWithStack(SinglyLinkedList<String> singlyLinkedList) {
        int listSize = singlyLinkedList.getSize();
        boolean oddFlag = isOdd(listSize);
        int secondHalfBeginIndex = getSecondHalfBeginIndex(singlyLinkedList, oddFlag);

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

    private static int getSecondHalfBeginIndex(SinglyLinkedList<String> singlyLinkedList, boolean oddFlag) {
        int listSize = singlyLinkedList.getSize();
        return oddFlag ?  listSize / 2 + 1 : listSize / 2;
    }

    private static boolean isOdd(int size) {
        boolean oddFlag = true;
        if (size % 2 == 0) {
            oddFlag = false;
        }
        return oddFlag;
    }

}
