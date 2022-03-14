package com.kuhleuski;

public enum Parts {
    HEAD(1),
    BODY(2),
    LEFT_HAND(3),
    RIGHT_HAND(4),
    LEFT_LEG(5),
    RIGHT_LEG(6),
    RAM(7),
    HDD(8),
    CPU(9);
    private int id;

    Parts(int id){
        this.id = id;
    }

    public static Parts ret(int id){
        return switch (id) {
            case 1 -> HEAD;
            case 2 -> BODY;
            case 3 -> LEFT_HAND;
            case 4 -> RIGHT_HAND;
            case 5 -> LEFT_LEG;
            case 6 -> RIGHT_LEG;
            case 7 -> RAM;
            case 8 -> HDD;
            default -> CPU;
        };
    }
}
