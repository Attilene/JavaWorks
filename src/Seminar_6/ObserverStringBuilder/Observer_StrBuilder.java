package Seminar_6.ObserverStringBuilder;

import java.util.ArrayList;

public class Observer_StrBuilder {
    private final StringBuilder stringBuilder;
    private final ArrayList<String> conditions;
    private final ArrayList<Observer> observers;

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
    }

    public void insert (int offset, String str) {
        stringBuilder.insert(offset, str);
        addCondition("insert(" + offset + ", '" + str + "')");
    }

    public void replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        addCondition("replace(" + start + ", " + end + ", '" + str + "')");
    }

    public void delete(int start, int end) {
        stringBuilder.delete(start, end);
        addCondition("delete(" + start + ", " + end + ")");
    }

    public void deleteCharAt(int index) {
        stringBuilder.deleteCharAt(index);
        addCondition("deleteCharAt(" + index + ")");
    }

    public void reverse() {
        stringBuilder.reverse();
        addCondition("reverse()");
    }

    public String substring(int start, int end) {
        addCondition("substring(" + start + ", " + end + ")");
        return stringBuilder.substring(start, end);
    }

    public String substring(int start) { return substring(start, stringBuilder.length()); }
}
