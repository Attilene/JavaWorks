package Seminar_6.UndoStringBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
    StringBuilder stringBuilder = new StringBuilder();

    public ActionTest() {
        stringBuilder.append("Hello");
    }

    @Test
    void undo() {
        UndoStrBuilder strBuilder = new UndoStrBuilder(stringBuilder);
        strBuilder.append("y");
//        strBuilder.replace(0, 2, "qw");
//        strBuilder.reverse();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
        strBuilder.redo();
        strBuilder.print();
//        strBuilder.undo();
//        strBuilder.print();
//        strBuilder.undo();
//        strBuilder.print();
    }
}