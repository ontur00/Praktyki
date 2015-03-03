/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

/**
 *
 * @author Radosław
 */
public class MainDecrementIncrement {

    public static void main(String[] args) {
        int[] tab = new int[2];
        
        //Utworzenie Runnable
        Runnable myRun = new MyRunChangeVariable(tab);
        Runnable myRun1 = new MyRunChangeVariable(tab);
        
        //Utworzenie watku
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun1);
        
        t1.start();
        t2.start();
    }
}
