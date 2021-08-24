package com.jwd.arrlist;

public class CustomArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    Object[] array;

    public CustomArrayList() {
        this.array = new Object[]{};
    }

    public CustomArrayList(int capacity) {
        if (capacity > 0) {
            this.array = new Object[capacity];
        } else if (capacity == 0) {
            this.array = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
    }


    public int size() {
        return size;
    }

    public E get(int index) {
        if ((index < size) && (index >= 0)) {
            return (E) array[index];
        }
        return null;
    }

    public void add(int index, Object element) {
        if (index < 0) {
            return;
        }
        if (size + 1 >= array.length) {
            expandArrayCapacity();
        }
        if (index > size) {
            index = size;
        }
        for (int i = size; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public Object set(int index, Object element) {
        if ((index < size) && (index >= 0)) {
            Object o = array[index];
            array[index] = element;
            return o;
        }
        return null;
    }

    public E remove(int index) {
        Object o = null;
        if ((index < size) && (index >= 0)) {
            o = get(index);
            removeEmptySpace(index);
        }
        return (E) o;
    }

    private void removeEmptySpace(int checkPoint) {
        size--;
        if (size <= 0) {
            return;
        }
        if (size != checkPoint) {
            System.arraycopy(array, checkPoint + 1, array, checkPoint, size - checkPoint);
        }
        array[size] = null;
    }

    private void expandArrayCapacity() {
        int ExpandedCapacity = DEFAULT_CAPACITY * 2;
        Object[] newArray = new Object[ExpandedCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
            array[i] = null;
        }
        array = newArray;
    }

}
