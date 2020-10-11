package Seminar_6.ObserverStringBuilder;

import Seminar_2.Task6_Seabattle.User_Interface;

import java.util.ArrayList;

public class User_Observer implements Observer {
    private final ArrayList<String> logs;
    public String name;

    public User_Observer(String name) {
        logs = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void notice(String condition) { logs.add(name + " get new condition of StringBuilder: " + condition); }

    public ArrayList<String> returnLogs() {
        return logs;
    }
}