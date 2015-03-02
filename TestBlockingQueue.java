/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Artur
 */
public class TestBlockingQueue {
    
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    
    
    public static void main(String[] args){
              
    }
    
    public void producer() throws InterruptedException{
     
        Random random = new Random();
        while(true){
            queue.put(random.nextInt(100));
        }
    }
}
