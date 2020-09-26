package Seminar_4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class IterAndStr<T> implements Iterator<String> {
    private Iterator<T> iter;
    private int index = 0;
    private boolean b;
    private final String str = "Следующий элемент";
    Random rd = new Random();

    public IterAndStr(Iterator<T> iter){
        this.iter = iter;
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public String next() {
//        index++;
//        System.out.println(index);
        if(!hasNext())
            throw new NoSuchElementException();
        b = rd.nextBoolean();
        if (b)
            return next();
        iter.next();
        return str;
    }
}