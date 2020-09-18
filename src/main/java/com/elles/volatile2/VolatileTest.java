package com.elles.volatile2;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {

    public static  void main(String [] args){
//        volatileTest();
        atomicTest2();


    }

    //volatile 不保证原子性，使用 sync/或者atomicInteger等方式解决原子性问题
    private static void atomicTest2() {
        MyData myData=new MyData();
        for(int i=1;i<=20;i++){


            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int j=1;j<=2000;j++){
                        myData.addPlus();
                        myData.addAtomic();
                    }
                }
            }).start();
        }

        while (Thread.activeCount()>2){

        }

        System.out.println("=========atomic,"+myData.i);
        System.out.println("=========atomic,"+myData.atomicInteger.get());
    }

    //** volatile 保证了线程之间的可见性
    private static void volatileTest() {
        MyData myData=new MyData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myData.addNumber();
            }
        }).start();

        while (myData.number==0){

        }

        System.out.println("current thread is +++"+myData.number);
    }
}


class  MyData{
    volatile  int number=0;

    volatile  int i=0;

    AtomicInteger atomicInteger=new AtomicInteger();

    public void addNumber(){
         number=60;
    }

    public void addPlus(){
        i++;
    }

    public  void addAtomic(){
        atomicInteger.incrementAndGet();
    }
}