package Seminar_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterat<T> implements Iterator<T> {
    private T[] array;
    private int index = 0;

    public Iterat(T[] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < this.array.length;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return this.array[index++];
    }
}
