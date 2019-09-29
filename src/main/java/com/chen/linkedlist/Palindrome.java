package com.chen.linkedlist;

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
        singlyLinkedList.add("A");

        System.out.println(validatePalindrome(singlyLinkedList));
    }

    public static boolean validatePalindrome(SinglyLinkedList<String> singlyLinkedList) {
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

}
