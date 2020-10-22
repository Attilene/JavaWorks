package Seminar_6.UndoStringBuilder;

import java.util.Stack;

public class UndoStrBuilder {
    private class Append implements Action {
        private final String str;

        public Append(String str) {
            this.str = str;
        }

        @Override
        public void undo() { stringBuilder.delete(stringBuilder.length() - str.length(), stringBuilder.length()); }

        @Override
        public void redo() { stringBuilder.append(str); }
    }

    private class undoReplace implements Action {
        private final int start, end;
        String str;

        public undoReplace(int start, int end, String str) {
            this.start = start;
            this.end = end;
            this.str = str;
        }

        @Override
        public void undo() { stringBuilder.replace(start, end, str); }

        @Override
        public void redo() {

        }
    }

    private class undoInsert implements Action {
        private final int offset;
        String str;

        public undoInsert(int offset, String str) {
            this.offset = offset;
            this.str = str;
        }

        @Override
        public void undo() { stringBuilder.delete(offset, str.length()); }

        @Override
        public void redo() {

        }
    }

    private class undoDelete implements Action {
        private final int offset;
        String str;

        public undoDelete(int offset, String str) {
            this.offset = offset;
            this.str = str;
        }

        @Override
        public void undo() { stringBuilder.insert(offset, str); }

        @Override
        public void redo() {

        }
    }

    private class undoCharDelete implements Action {
        private final int index;
        char elem;

        public undoCharDelete(int index, char elem) {
            this.index = index;
            this.elem = elem;
        }

        @Override
        public void undo() { stringBuilder.insert(index, elem); }

        @Override
        public void redo() {

        }
    }

    private class undoReverse implements Action {
        @Override
        public void undo() { stringBuilder.reverse(); }

        @Override
        public void redo() {

        }
    }


    private final StringBuilder stringBuilder;
    public Stack<Action> actionStack = new Stack<>();
    public Stack<Action> redo_actionStack = new Stack<>();

    public UndoStrBuilder(StringBuilder stringBuilder) { this.stringBuilder = stringBuilder; }

    public void append (String str) {
        stringBuilder.append(str);
        Append unapp = new Append(str);
        actionStack.push(unapp);
    }

    public void insert (int offset, String str) {
        stringBuilder.insert(offset, str);
        undoInsert unins = new undoInsert(offset, str);
        actionStack.push(unins);
    }

    public void replace(int start, int end, String str) {
        String repstr = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        undoReplace unrep = new undoReplace(start, end, repstr);
        actionStack.push(unrep);
    }

    public void delete(int start, int end) {
        String delstr = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        undoDelete undel = new undoDelete(start, delstr);
        actionStack.push(undel);
    }

    public void deleteCharAt(int index) {
        char elem = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        undoCharDelete unchdel = new undoCharDelete(index, elem);
        actionStack.push(unchdel);
    }

    public void reverse() {
        stringBuilder.reverse();
        undoReverse unrev = new undoReverse();
        actionStack.push(unrev);
    }

    public String substring(int start, int end) { return stringBuilder.substring(start, end); }

    public String substring(int start) { return substring(start, stringBuilder.length()); }

    public void undo() {
        redo_actionStack.push(actionStack.peek());
        actionStack.pop().undo();
    }

    public void redo() { redo_actionStack.pop().redo(); }

    public void print() { System.out.println(stringBuilder); }
}
