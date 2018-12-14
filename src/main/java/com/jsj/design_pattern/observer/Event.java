package com.jsj.design_pattern.observer;

import java.util.LinkedList;
import java.util.List;

public class Event {
    private List<Listener> listeners;

    public Event() {
        this.listeners = new LinkedList<>();
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void notifyListeners() {
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).complete();
        }
    }
}
