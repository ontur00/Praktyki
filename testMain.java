/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur
 */
public class testMain {

    public static void main(String[] args) {           
        
        LowLevelSynchro lowLevelSyn = new LowLevelSynchro();        
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    lowLevelSyn.producer();
          
                } catch (InterruptedException ex) {
                    Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    lowLevelSyn.consumer();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        t1.start();
        t2.start();
        
        try {
            t1.join();
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(testMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
