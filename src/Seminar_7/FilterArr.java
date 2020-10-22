package Seminar_7;

import java.util.Arrays;
import java.util.function.Function;

public class FilterArr {
    public static<T> T[] filter(T[] arr, Function<T, Boolean> filt) {
        int index = 0;
        for (T elem: arr) {
            if (filt.apply(elem)) {
                arr[index] = elem;
                index++;
            }
        }
        return Arrays.copyOf(arr, index);
    }
}
