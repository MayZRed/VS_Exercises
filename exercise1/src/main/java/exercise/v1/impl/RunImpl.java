package exercise.v1.impl;

import exercise.v1.service.RunExe1;

import java.io.IOException;

public class RunImpl implements RunExe1 {

    public static void main(String[] args) {
        try {
            LoginWindow currWindow = new LoginWindow();
            currWindow.notify();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runE1() {
        System.out.println("takes main later on");
    }
}
