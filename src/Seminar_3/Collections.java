package Seminar_3;

import java.util.Collection;
import java.util.HashSet;

public class Collections {
    public <T> Collection<T> remDupl(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}
