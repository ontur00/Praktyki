/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.Scanner;

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
    
    public void testNotify(){
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized(this){
            
        }
    }
}
public class Process {
    
    public static void main(String[] args){
        
    }
}
