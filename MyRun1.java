/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radog90
 */
public class MyRun1 implements Runnable {

    public AtomicInteger[] zmienna;
    public int id;
    public static Random vrcA;
    public Object lock = new Object();

    public MyRun1(AtomicInteger[] zmienna, int id) {
        this.zmienna = zmienna;
        this.id = id;
        if (vrcA == null) {
            vrcA = new Random(System.nanoTime());
        }
        //this.zmienna = 100;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (zmienna) {
            try {
                if (id == 1) {
                    Thread.sleep(vrcA.nextInt(1000));
                } else {
                    Thread.sleep(1);
                }
            } catch (InterruptedException ex) {
//                    Logger.getLogger(MyRun.class.getName()).log(Level.SEVERE, null, ex);
            }
            setToZero();
            increment();
            }
        }

    }

    public  void increment() {
        if (zmienna[0].get() >= 0 && id == 2) {
            zmienna[0].getAndAdd(20);
            System.out.println("Watek " + this.id + "\t     " + zmienna[0]);
        }
        
    }

    public  void setToZero() {
        if (zmienna[0].get() >= 0 && id == 1) {
            zmienna[0].set(0);
            System.out.println("Watek " + this.id + "\t     " + zmienna[0].get());
            for (int i = 0; i < 100000; ++i);
//                 try {
//                    if (id == 1)
//                    Thread.sleep(vrcA.nextInt(50));
//                   
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(MyRun.class.getName()).log(Level.SEVERE, null, ex);
//                }
            System.out.println("Watek " + this.id + "\t     " + zmienna[0].get());
        }
    }
}
