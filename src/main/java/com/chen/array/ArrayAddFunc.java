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
        ensureCapacity(plusInt(size, 1));
        elements[size++] = element;
        return true;
    }

    private void ensureCapacity(int minCapacity) {
       // mod ++
        if (minCapacity > capacity) {
            growCapacity(minCapacity);
        }
    }

    private void growCapacity(int minCapacity) {
        int newCapacity ;
        do {
            if (validatePlusOverflow(capacity, capacity)) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = capacity << 1;
            }
        } while (newCapacity < minCapacity && newCapacity < Integer.MAX_VALUE);

        elements = Arrays.copyOf(elements, newCapacity);
        capacity = newCapacity;
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    private int plusInt(int a, int b) {
        if (validatePlusOverflow(a, b)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a)
                    .append(" plus ")
                    .append(b)
                    .append(" overflow!");

            throw new OutOfMemoryError(stringBuilder.toString());
        }
        return a + b;
    }

    /**
     * validate if plus result overflow
     * @param a
     * @param b
     * @return
     */
    private boolean validatePlusOverflow(int a , int b) {
        boolean positiveOverflow = a >= 0 && b >= 0 && a > (Integer.MAX_VALUE - b);
        boolean negativeOverflow = a < 0 && b < 0 && (a < Integer.MIN_VALUE - b);

        if (positiveOverflow || negativeOverflow) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }



    public static void main(String[] args) {

    }

}
