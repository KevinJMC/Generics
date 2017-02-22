package mccann.kevin.generics;

/**
 * Created by kevinmccann on 2/22/17.
 */
public class MySet<T> {

    MyArrayList<T> holderList = new MyArrayList<>();

    void add(T t) {
        if(!(holderList.contains(t)))
            holderList.add(t);
    }

    void clear() {
        holderList.clear();
    }

    boolean contains(T t) {
        return holderList.contains(t);
    }

    public boolean equals(Object obj) {
        if(! (obj instanceof MySet))
            return false;
        if(((MySet) obj).holderList.size()!= holderList.size())
            return false;
        for(int i = 0; i<holderList.size(); i++){
            if(!(holderList.get(i).equals((((MySet) obj).holderList.get(i)))))
                return false;
        }
        return true;
    }

    boolean isEmpty() {
        return holderList.isEmpty();
    }

    boolean remove(T t) {
        return holderList.remove(t);
    }

    int size() {
        return holderList.size();
    }

    Object[] toArray() {
        return holderList.toArray();
    }


}
