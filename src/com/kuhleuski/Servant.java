package com.kuhleuski;

import java.util.List;
import java.util.Random;

class Servant implements Runnable{
    private Random random = new Random();
    private Dumb dumbSource;
    private Storage storageSource;

    public Servant(Dumb dumbSource, Storage storageSource){
        this.dumbSource = dumbSource;
        this.storageSource= storageSource;
    }



    @Override
    public void run() {

        for (int i =0; i< Main.COUNT_NIGHTS; i++){
            storageSource.updateListVar();
            for (int j = 0; j< random.nextInt(Main.RANDOM_DETAILS_TAKE_COUNT)+1; j++){
                synchronized (dumbSource){
                    if (dumbSource.isDumbEmpty()){
                        break;
                    }
                    storageSource.addStorageItem(dumbSource.takeDumbItem());
                }
            }
            storageSource.printStorage();

            while (storageSource.isContainsItems(List.of(Parts.values()))){
                storageSource.assembleRobot();
                storageSource.incCountRobots();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Кол-во роботов у " + Thread.currentThread().getName() + " ученого: " + storageSource.getCountRobots());
    }
}