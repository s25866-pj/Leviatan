package com.example.leviatan.Utilz;

public enum Type {
    Reactor(1),
    Greenhouse(2),
    Elevator(0),
    Cargo(0),
    Command_Bridge(0);


    private int returningSource;

    Type(int returningSource) {
        this.returningSource = returningSource;
    }

    public int getReturningSource() {
        return returningSource;
    }
}
