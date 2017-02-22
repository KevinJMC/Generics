package mccann.kevin.generics;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MyMap<E,T> {

    MyArrayList<MyEntry> holderList = new MyArrayList<>();

    void clear() {
        holderList.clear();
    }

    boolean containsKey(E key) {
        for(int i = 0; i<holderList.size(); i++) {
            if(holderList.get(i).getKey() == key)
                return true;
        } return false;
    }

    boolean containsValue(T value) {
        for(int i = 0; i<holderList.size(); i++) {
            if(holderList.get(i).getValue() == value)
                return true;
        } return false;
    }

    MySet<MyEntry> entrySet() {
        MySet<MyEntry> holdSet = new MySet<>();
        for (int i = 0; i < holderList.size(); i++) {
            holdSet.add(holderList.get(i));
        }
        return holdSet;
    }

//    public boolean equals(Object O) {}

    @SuppressWarnings("unchecked")
    T get(E key) {
        for (int i = 0; i < holderList.size(); i++) {
            if(holderList.get(i).getKey() == key)
                return (T) holderList.get(i).getValue();
        }
        return null;
    }

//    public int hashCode() {}

    boolean isEmpty() {
        return holderList.isEmpty();
    }

    MySet<E> keySet() {
        MySet<E> holdSet = new MySet<>();
        for (int i = 0; i < holderList.size(); i++) {
            holdSet.add((E)holderList.get(i).getKey());
        }
        return holdSet;
    }


    void put(E key, T value) {
        holderList.add(new MyEntry(key, value));
    }

    void remove(E key) {
        for (int i = 0; i < holderList.size(); i++) {
            if(holderList.get(i).getKey()==key)
                holderList.remove(i);
        }
    }

    int size() {
        return holderList.size();
    }

    @SuppressWarnings("unchecked")
    MyArrayList<T> values() {
        MyArrayList<T> tempList = new MyArrayList<T>();
        for (int i = 0; i < holderList.size(); i++) {
            tempList.add((T) holderList.get(i).getValue());
        }
        return tempList;
    }

    class MyEntry<E,T> {
        E key;

        T value;

        E getKey() {
            return key;
        }

        T getValue() {
            return value;
        }

        MyEntry (E e, T t) {
            this.key = e;
            this.value = t;
        }
    }
}
