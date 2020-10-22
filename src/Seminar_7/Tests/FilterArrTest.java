package Seminar_7.Tests;

import Seminar_7.FilterArr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterArrTest {

    @Test
    void filter() {
        String[] arr = {"adfsdf", "Ad", "asdadfjkth", null};
        String[] newarr = FilterArr.filter(arr, s -> s != null && s.length() > 3);

        for (String str: newarr) {
            System.out.println(str);
        }
    }
}