package Seminar_7.Tests;

import Seminar_7.ZeroCross;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroCrossTest {

    @Test
    void newGame() {
        String[] names = {"Artem", "Dima"};
        ZeroCross cr = new ZeroCross(3, names);
        cr.newGame();
    }

}