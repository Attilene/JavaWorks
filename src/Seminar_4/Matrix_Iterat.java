package Seminar_4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Matrix_Iterat<T> implements Iterator<T> {
    private T[][] array;
    private int index = 0;

    public Matrix_Iterat(T[][] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return index < this.array.length * this.array[0].length;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw new NoSuchElementException();
        return this.array[index / this.array[0].length][index++ % this.array[0].length];
    }
}