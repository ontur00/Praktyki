/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import Wielowatkowosc.MainDecrementIncrement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Radosław
 */
public class MainDecrementIncrement {

    public static void main(String[] args) {
        int[] tab = new int[2];
        
        //Utworzenie MyRunChangeVariable
        MyRunChangeVariable przekazFunkcje = new MyRunChangeVariable(tab);
                     
                
//        //Utworzenie watku
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                long startTime = System.nanoTime();
                
                try {                    
                    przekazFunkcje.increment(startTime);    
                } catch (InterruptedException ex) {
                    
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    przekazFunkcje.decrement();
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainDecrementIncrement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t1.start();
        t2.start();
                
    }
}
