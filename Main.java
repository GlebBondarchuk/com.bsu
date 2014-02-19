package com.bsu;

public class Main {
    public static synchronized void main(String[] args) {
        for(int i = 0; i < 10;) {
            throw new RuntimeException();
        }
    }
}
