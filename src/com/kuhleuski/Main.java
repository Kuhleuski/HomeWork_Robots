package com.kuhleuski;

import java.util.Random;

public class Main{

    public static final int PARTS_SET = Parts.values().length;
    public static final int COUNT_NIGHTS = 100;
    public static final int RANDOM_DETAILS_PUT_COUNT = 4;
    public static final int RANDOM_DETAILS_TAKE_COUNT = 4;

    public static void main(String[] args) {

        Storage storage1 = new Storage();
        Storage storage2 = new Storage();
        Dumb dumb = new Dumb();


        Factory factory = new Factory(dumb);
        Servant s1 = new Servant(dumb,storage1);
        Servant s2 = new Servant(dumb,storage2);


        Random random = new Random();
        for (int i=0;i<20;i++){
            dumb.addDumbItem(Parts.ret(random.nextInt(PARTS_SET+1)));
        }

        System.out.println("Хранилища с деталями: ");
        Thread factoryT = new Thread(factory);
        Thread servant1T = new Thread(s1,"1");
        Thread servant2T = new Thread(s2,"2");

        factoryT.start();
        servant1T.start();
        servant2T.start();

    }
}
