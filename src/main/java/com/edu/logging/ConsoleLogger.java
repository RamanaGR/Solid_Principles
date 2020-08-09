package com.edu.logging;

public class ConsoleLogger {
    public void writeInfo(String msg) {
        System.out.println("Info: " + msg);
    }

    public void writeError(String msg, Exception exe) {
        System.err.println("Error: " + msg + ";" + exe);
    }
}
