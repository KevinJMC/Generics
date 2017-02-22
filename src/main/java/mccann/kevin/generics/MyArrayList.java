package mccann.kevin.generics;

import java.util.Arrays;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MyArrayList<T>{
    Object[] holderList;
    private int size;

    void add(T t) {
        ensureCapacity(size+1);
        holderList[size++] = t;
    }

    void add(T t, int index) {
        ensureCapacity(size+1);
        holderList[index] = t;
        size++;

    }

    void clear() {
        for(int i = 0; i < size; i++) {
            holderList[i] = null;
        }
        size = 0;
    }

    boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    void ensureCapacity(int capacity) {
        int oldCapacity = holderList.length;
        if(capacity > oldCapacity) {
            Object[] temp = holderList;
            int newCapacity = (int)Math.ceil(oldCapacity*1.7);
            if(newCapacity < capacity)
                newCapacity = capacity;
            holderList = Arrays.copyOf(holderList, newCapacity);
        }
    }

    @SuppressWarnings("unchecked")
    T get(int index) throws IndexOutOfBoundsException{
        if(index>size)
            throw new IndexOutOfBoundsException("Invalid index");
        return (T) holderList[index];
    }

    int indexOf(T t) {
        for(int i = 0; i < size; i++) {
            if(t.equals(holderList[i]))
                return i;
        }
        return -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int lastIndexOf(T t) {
        for(int i = size - 1; i >= 0; i--) {
            if(t.equals(holderList[i]))
                return i;
        }
        return -1;
    }

    void remove(int index) {
        System.arraycopy(holderList, index + 1, holderList, index, size - index - 1 );
        holderList[--size] = null;
    }

    boolean remove(T t) {
        for(int i = 0; i < size; i++) {
            if(t.equals(holderList[i])) {
                remove(i);
                return true;
            }
        } return false;
    }

    void removeRange(int fromIndex, int toIndex) {
        System.arraycopy(holderList, toIndex, holderList, fromIndex, size - toIndex);
        int newSize = size - toIndex - fromIndex;
            while(!(size == newSize)) {
                holderList[--size] = null;
            }
    }

    void set(int index, T t) {
        holderList[index] = t;
    }

    int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    MyArrayList<T> subList(int fromIndex, int toIndex) throws Exception {
        try {
            if (fromIndex < 0)
                throw new IndexOutOfBoundsException("fromIndex = " + fromIndex);
            if (toIndex > size)
                throw new IndexOutOfBoundsException("toIndex = " + toIndex);
            if ( fromIndex > toIndex)
                throw new IllegalArgumentException("fromIndex > toIndex");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MyArrayList<T> subList = new MyArrayList<>();
        for(int i = fromIndex; i< toIndex; i++) {
            subList.add((T)holderList[i]);
        }
//        System.arraycopy(holderList, fromIndex, subList.holderList, 0, toIndex-fromIndex);
        return subList;
    }

    Object[] toArray() {
        return Arrays.copyOf(holderList, size);
    }

    void trimToSize() {
        int oldCapacity = holderList.length;
        if (size < oldCapacity) {
            holderList = Arrays.copyOf(holderList, size);
        }
    }

    MyArrayList(int size) {
        this.holderList = new Object[size];
    }

    MyArrayList() {
        this.holderList = new Object[10];
    }

}