/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur
 */

class testWaitNotify{

    public void testWait() throws InterruptedException{
        synchronized(this){
            System.out.println("Starting ");
            wait();
            System.out.println("After wait");
        }
    }
    
    public void testNotify()throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);
        
        synchronized(this){
            System.out.println("Waiting for return key");
            scan.next();
            System.out.println("Return key for pressed");
            notify();
        }
    }
}
public class Process {
    
    public static void main(String[] args){
        testWaitNotify tesWaitNot = new testWaitNotify();
        
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    tesWaitNot.testWait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    tesWaitNot.testNotify();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Process.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t1.start();
        t2.start();
    }
}
