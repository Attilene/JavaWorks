package Seminar_6.ObserverStringBuilder;

import Seminar_6.UndoStringBuilder.*;

import java.util.ArrayList;
import java.util.Stack;

public class Observer_StrBuilder {
    private class Append implements Action {
        @Override
        public void undo() { stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length()); }

        @Override
        public void redo() {

        }
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
    private final ArrayList<String> conditions;
    private final ArrayList<Observer> observers;
    public Stack<Action> actionStack = new Stack<>();

    public Observer_StrBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        conditions = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) { observers.add(observer); }

    public void removeObserver(Observer observer) { observers.remove(observer); }

    private void addCondition(String condition) {
        conditions.add(condition);
        System.out.printf("StringBuilder changed its condition: %s \n", condition);
        notifyObservers(condition);
    }

    private void notifyObservers(String condition) {
        for (Observer observer: observers) { observer.notice(condition); }
    }

    public void print() { System.out.println(stringBuilder); }

    public void append (String str) {
        stringBuilder.append(str);
        addCondition("append('" + str + "')");
        Append unapp = new Append();
        actionStack.push(unapp);
    }

    public void insert (int offset, String str) {
        stringBuilder.insert(offset, str);
        addCondition("insert(" + offset + ", '" + str + "')");
        undoInsert unins = new undoInsert(offset, str);
        actionStack.push(unins);
    }

    public void replace(int start, int end, String str) {
        String repstr = stringBuilder.substring(start, end);
        stringBuilder.replace(start, end, str);
        addCondition("replace(" + start + ", " + end + ", '" + str + "')");
        undoReplace unrep = new undoReplace(start, end, repstr);
        actionStack.push(unrep);
    }

    public void delete(int start, int end) {
        String delstr = stringBuilder.substring(start, end);
        stringBuilder.delete(start, end);
        addCondition("delete(" + start + ", " + end + ")");
        undoDelete undel = new undoDelete(start, delstr);
        actionStack.push(undel);
    }

    public void deleteCharAt(int index) {
        char elem = stringBuilder.charAt(index);
        stringBuilder.deleteCharAt(index);
        addCondition("deleteCharAt(" + index + ")");
        undoCharDelete unchdel = new undoCharDelete(index, elem);
        actionStack.push(unchdel);
    }

    public void reverse() {
        stringBuilder.reverse();
        addCondition("reverse()");
        undoReverse unrev = new undoReverse();
        actionStack.push(unrev);
    }

    public String substring(int start, int end) { return stringBuilder.substring(start, end); }

    public String substring(int start) { return substring(start, stringBuilder.length()); }

    public void undo() {
        addCondition("undo()");
        actionStack.pop().undo();
    }
}
