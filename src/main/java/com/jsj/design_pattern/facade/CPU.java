package com.jsj.design_pattern.facade;

public class CPU implements Component {
    @Override
    public void start() {
        System.out.println("CPU START!");
    }

    @Override
    public void shutdown() {
        System.out.println("CPU SHUTDOWN...");
    }
}
