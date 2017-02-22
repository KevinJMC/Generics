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

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if(! (o instanceof MyMap))
            return false;
        if(((MyMap) o).holderList.size()!= holderList.size())
            return false;
        for(int i = 0; i<holderList.size(); i++){
            if(!(holderList.get(i).equals((((MyMap) o).holderList.get(i)))))
                return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    T get(E key) {
        for (int i = 0; i < holderList.size(); i++) {
            if(holderList.get(i).getKey() == key)
                return (T) holderList.get(i).getValue();
        }
        return null;
    }

    boolean isEmpty() {
        return holderList.isEmpty();
    }

    @SuppressWarnings("unchecked")
    MySet<E> keySet() {
        MySet<E> holdSet = new MySet<>();
        for (int i = 0; i < holderList.size(); i++) {
            holdSet.add((E)holderList.get(i).getKey());
        }
        return holdSet;
    }


    void put(E key, T value) {
        holderList.add(new MyEntry<>(key, value));
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

        @Override
        public boolean equals(Object obj) {
            if(! (obj instanceof MyEntry))
                return false;
            if(((MyEntry) obj).getKey()!= getKey())
                return false;
            if(((MyEntry) obj).getValue()!= getValue())
                return false;
            return true;
        }
    }
}
