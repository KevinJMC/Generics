package mccann.kevin.generics;

import java.util.Arrays;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MyArrayList<T>{
    private Object[] holderArray;
    private int size;

    void add(T t) {
        ensureCapacity(size+1);
        holderArray[size++] = t;
    }

    void add(T t, int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        ensureCapacity(size+1);
        holderArray[index] = t;
        size++;
    }

    void clear() {
        for(int i = 0; i < size; i++) {
            holderArray[i] = null;
        }
        size = 0;
    }

    boolean contains(T t) {
        return indexOf(t) >= 0;
    }

    void ensureCapacity(int capacity) {
        int oldCapacity = holderArray.length;
        if(capacity > oldCapacity) {
            int newCapacity = (int)Math.ceil(oldCapacity*1.7);
            if(newCapacity < capacity)
                newCapacity = capacity;
            holderArray = Arrays.copyOf(holderArray, newCapacity);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MyArrayList))
            return false;
        if (((MyArrayList) obj).size() != size())
            return false;
        for (int i = 0; i < size(); i++) {
            if (!(holderArray[i].equals(((MyArrayList) obj).holderArray[i])))
                return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    T get(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        return (T) holderArray[index];
    }

    int indexOf(T t) {
        for(int i = 0; i < size; i++) {
            if(t.equals(holderArray[i]))
                return i;
        }
        return -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    int lastIndexOf(T t) {
        for(int i = size - 1; i >= 0; i--) {
            if(t.equals(holderArray[i]))
                return i;
        }
        return -1;
    }

    void remove(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        System.arraycopy(holderArray, index + 1, holderArray, index, size - index - 1 );
        holderArray[--size] = null;
    }

    boolean remove(T t) {
        for(int i = 0; i < size; i++) {
            if(t.equals(holderArray[i])) {
                remove(i);
                return true;
            }
        } return false;
    }

    void removeRange(int fromIndex, int toIndex) {
        System.arraycopy(holderArray, toIndex, holderArray, fromIndex, size - toIndex);
        int newSize = size - toIndex - fromIndex;
            while(!(size == newSize)) {
                holderArray[--size] = null;
            }
    }

    void set(int index, T t) throws IndexOutOfBoundsException{
        checkIndex(index);
        holderArray[index] = t;
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
            subList.add((T) holderArray[i]);
        }
//        System.arraycopy(holderArray, fromIndex, subList.holderArray, 0, toIndex-fromIndex);
        return subList;
    }

    Object[] toArray() {
        return Arrays.copyOf(holderArray, size);
    }

    void trimToSize() {
        int oldCapacity = holderArray.length;
        if (size < oldCapacity) {
            holderArray = Arrays.copyOf(holderArray, size);
        }
    }

    MyArrayList(int size) {
        this.holderArray = new Object[size];
    }

    MyArrayList() {
        this.holderArray = new Object[10];
    }

    void checkIndex(int index){
        if(index>size)
            throw new IndexOutOfBoundsException("Invalid index");
    }
}