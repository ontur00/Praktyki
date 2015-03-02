/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author radog90
 */
public class TworzenieWatkow {

    static final AtomicInteger[] zmienna = new AtomicInteger[2];

    public static void main(String[] args) {
        System.out.println(zmienna[0]);
        for(int i=0; i<1; i++){
            zmienna[i] = new AtomicInteger(i);
        }
//        add(zmienna, 90);

        //Interfejs Runnable        
        Runnable run1 = new MyRun1(zmienna, 1);
        Thread t1 = new Thread(run1);
        t1.start();

        for (int i = 0; i < 1; ++i) {
            Runnable run2 = new MyRun1(zmienna, 2);

            //Watki
            Thread t2 = new Thread(run2);

            //Praca watków
            t2.start();

//            try {
//                t1.join();
//                t2.join();
//            } catch (InterruptedException ex) {
//                Logger.getLogger(TworzenieWatkow.class.getName()).log(Level.SEVERE, null, ex);
//            }

        }

    }

    public static void add(AtomicInteger[] zmienna, int ileDodac) {
        zmienna[0].set(ileDodac);
    }
}
