package Seminar_6.ObserverStringBuilder;

import java.util.ArrayList;

public class User_Observer implements Observer {
    private final ArrayList<String> logs;

    public User_Observer() { logs = new ArrayList<>(); }

    @Override
    public void notice(String condition) { logs.add("Observer1 get new condition of StringBuilder: " + condition); }

    public ArrayList<String> returnLogs() {
        return logs;
    }
}