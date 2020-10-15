package Seminar_6.UndoStringBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @Test
    void undo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        UndoStrBuilder strBuilder = new UndoStrBuilder(stringBuilder);
        strBuilder.append("y");
        strBuilder.replace(0, 2, "qw");
        strBuilder.reverse();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
    }
}