package Seminar_6.ObserverStringBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {

    @Test
    void notice() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        User_Observer obs1 = new User_Observer("Artem");
        User_Observer obs2 = new User_Observer("Dima");
        Observer_StrBuilder observer_strBuilder = new Observer_StrBuilder(stringBuilder);
        observer_strBuilder.addObserver(obs1);
        observer_strBuilder.addObserver(obs2);
        observer_strBuilder.append("y");
        observer_strBuilder.print();
        observer_strBuilder.undo();
        observer_strBuilder.print();
        observer_strBuilder.removeObserver(obs2);
        observer_strBuilder.replace(0, 2, "qw");
        observer_strBuilder.print();
        observer_strBuilder.reverse();
        observer_strBuilder.print();
        System.out.println(obs1.returnLogs());
        System.out.println(obs2.returnLogs());
    }
}