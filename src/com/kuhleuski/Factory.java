package com.kuhleuski;


import java.util.Random;

class Factory implements Runnable{
    private Random random = new Random();
    private Dumb dumbSource;

   public Factory(Dumb dumbSource){
       this.dumbSource = dumbSource;
    }
    @Override
    public void run() {
        for (int i =0;i<Main.COUNT_NIGHTS;i++){
            for (int j = 0; j< random.nextInt(Main.RANDOM_DETAILS_PUT_COUNT) +1; j++){
                dumbSource.addDumbItem(Parts.ret(random.nextInt(9)+1));
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}