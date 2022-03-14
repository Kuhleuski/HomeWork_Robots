package com.kuhleuski;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dumb {
    private Random random;
    private List<Parts> dumb;

    public Dumb(){
        random = new Random();
        dumb = new ArrayList<>();
    }

    public synchronized boolean isDumbEmpty(){
        return dumb.isEmpty();
    }
    public synchronized void addDumbItem(Parts item){
        dumb.add(item);
    }
    public synchronized Parts takeDumbItem(){
        return dumb.remove(random.nextInt(dumb.size())); // Почему тут рандомное число стоит?
    }
}
