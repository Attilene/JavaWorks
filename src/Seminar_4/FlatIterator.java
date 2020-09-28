package Seminar_4;

import java.util.ArrayList;
import java.util.Iterator;

public class FlatIterator<T> implements Iterator<T> {
    private int index = 0;
    ArrayList<T> arr = new ArrayList<>();

    public FlatIterator(Iterator<T> iter){
        while (iter.hasNext()){
            arr.add(iter.next());
        }
    }

    @Override
    public boolean hasNext() {
        return index < arr.size();
    }

    @Override
    public T next() {
        return arr.get(index++);
    }
}
