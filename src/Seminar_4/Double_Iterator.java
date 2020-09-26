package Seminar_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Double_Iterator<T> implements Iterator<T> {
    private Iterator<T> iter1, iter2;

    public Double_Iterator(Iterator<T> iter1, Iterator<T> iter2){
        this.iter1 = iter1;
        this.iter2 = iter2;
    }

    @Override
    public boolean hasNext() {
        return iter2.hasNext();
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        if (iter1.hasNext()){
            return iter1.next();
        }
        return iter2.next();
    }
}
