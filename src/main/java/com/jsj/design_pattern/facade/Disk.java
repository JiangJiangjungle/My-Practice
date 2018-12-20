package com.jsj.design_pattern.facade;

public class Disk implements Component {
    @Override
    public void start() {
        System.out.println("Disk START!");
    }

    @Override
    public void shutdown() {
        System.out.println("Disk SHUTDOWN...");
    }
}
