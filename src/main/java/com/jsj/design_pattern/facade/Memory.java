package com.jsj.design_pattern.facade;

public class Memory implements Component {
    @Override
    public void start() {
        System.out.println("Memory START!");
    }

    @Override
    public void shutdown() {
        System.out.println("Memory SHUTDOWN...");
    }
}
