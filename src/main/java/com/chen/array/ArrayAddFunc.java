package com.chen.array;

import java.util.Arrays;

/**
 * @author CXX
 * @date 2019/9/18 10:37
 */
public class ArrayAddFunc {

    private int[] elements = new int[10];
    private int capacity = 10;
    private int size = 0;

    public boolean add(int element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
       // mod ++
        if (minCapacity > capacity) {
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private void grow (int minCapacity) {
        if (minCapacity > MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError("array length over");
        }
        int newCapacity ;
        do {
            newCapacity = capacity << 1;
            if (newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = MAX_ARRAY_SIZE;
            }
        } while (newCapacity < minCapacity);

        elements = Arrays.copyOf(elements, newCapacity);
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        ArrayAddFunc arrayAddFunc = new ArrayAddFunc();

        for (int i = 1; i<100; i++) {
            arrayAddFunc.add(i);
        }
        System.out.println(arrayAddFunc.capacity);
        System.out.println(arrayAddFunc.size);
    }

}
