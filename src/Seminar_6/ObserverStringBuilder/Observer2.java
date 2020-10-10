package Seminar_6.ObserverStringBuilder;

import java.util.ArrayList;

public class Observer2 implements Observer {
    private final ArrayList<String> logs;

    public Observer2() { logs = new ArrayList<>(); }

    @Override
    public void notice(String condition) { logs.add("Observer2 get new condition of StringBuilder: " + condition); }

    public ArrayList<String> returnLogs() {
        return logs;
    }
}
