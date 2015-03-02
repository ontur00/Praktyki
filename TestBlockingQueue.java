/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur
 */
public class TestBlockingQueue {
    
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    
    public static void main(String[] args){
         Thread t1 = new Thread(new Runnable() {

             @Override
             public void run() {
                 try {
                     producer();
                 } catch (InterruptedException ex) {
                     Logger.getLogger(TestBlockingQueue.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         });
         
         Thread t2 = new Thread(new Runnable() {

             @Override
             public void run() {
                 try {
                     consumer();
                 } catch (InterruptedException e) {
                     System.err.println("Interrupt exception");
                     e.printStackTrace();
                 }
             }
         });
         
         t1.start();
         t2.start();
         
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(TestBlockingQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    public static void producer() throws InterruptedException{
     
        Random random = new Random();
        while(true){
            Thread.sleep(random.nextInt(1000));
            int putValue = random.nextInt(100);
            queue.put(putValue);
            System.err.println("Put value " + putValue);
        }
    }
    
    public static void consumer() throws InterruptedException{
        Random random = new Random();
        
        while(true){
            Thread.sleep(random.nextInt(1000));
//            if( random.nextInt(10) == 0){
                Integer value = queue.take();
                System.out.println("Size queue " + queue.size() + "  Taken value " + value);
//            }
        }
    }
}
