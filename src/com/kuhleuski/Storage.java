package com.kuhleuski;

import java.util.*;

public class Storage {

    private Random random;
    private List<Parts> storage;
    private int countRobots;

    public Storage() {
        random = new Random();
        storage = new ArrayList<>();

    }

    public void printStorage() {
        System.out.println(Thread.currentThread().getName() + ": "
                + Arrays.toString(storage.toArray()) + " +" + (storage.size() - listSize));
    }

    public void assembleRobot() {
        for (int i = 1; i < Main.PARTS_SET + 1; i++) {
            storage.remove(Parts.ret(i));
        }
    }

    public void addStorageItem(Parts item) {
        storage.add(item);
    }

    public boolean isContainsItems(Collection<Parts> c) {
        return storage.containsAll(c);
    }

    public int getCountRobots() {
        return countRobots;
    }

    public void incCountRobots() {
        countRobots++;
    }

    private int listSize;

    public void updateListVar() {
        listSize = storage.size();
    }

}
