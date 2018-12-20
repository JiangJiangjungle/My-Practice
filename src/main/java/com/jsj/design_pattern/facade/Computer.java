package com.jsj.design_pattern.facade;

public class Computer {
    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer() {
        this.cpu = new CPU();
        this.disk = new Disk();
        this.memory = new Memory();
    }

    void startComputer() {
        this.cpu.start();
        this.memory.start();
        this.disk.start();
    }

    void shutdownComputer() {
        this.cpu.shutdown();
        this.memory.shutdown();
        this.disk.shutdown();
    }
}
