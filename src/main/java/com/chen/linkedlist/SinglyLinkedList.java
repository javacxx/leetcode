package com.chen.linkedlist;

/**
 * @author CXX
 * @date 2019/9/29 11:41
 */
public class SinglyLinkedList<E>{

    private transient int size = 0;
    private transient Node<E> first;
    private transient Node<E> last;

    public SinglyLinkedList (){}

    public boolean add(E element) {
        Node<E> newNode = createNode(element);
        final Node<E> oldLast = last;
        last = newNode;

        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }

        size++;
        return true;
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> tmp = first;
        for (int i=1; i<=index; i++) {
            tmp = tmp.next;
        }
        return tmp.element;
    }




    private Node<E> createNode(E element, Node next) {
        return new Node<>(element, next);
    }
    private Node<E> createNode(E element) {
        return new Node<>(element);
    }

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
