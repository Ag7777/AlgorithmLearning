package com.hjx.JUC;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenterLockTest implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;
    @Override
    public void run(){
        for(int j = 0; j < 10000000; j ++){
            lock.lock();
            try{
                i ++ ;
            }finally{
                lock.unlock();
            }
        }
    }

    public static void main(String[] args)throws InterruptedException{
        ReenterLockTest t = new ReenterLockTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);

    }
}


