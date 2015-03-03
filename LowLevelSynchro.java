/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Wielowatkowosc;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Artur
 */
public class LowLevelSynchro {

    private LinkedList list = new LinkedList<Integer>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void producer() throws InterruptedException {

        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    lock.wait();
                }

                Random random = new Random();
                int putValue = random.nextInt(30) + 10;
                list.add(putValue);
                System.out.println("Producer add " + putValue + "  size " + list.size());
                lock.notify();                
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }

                int takeValue = (int) list.removeFirst();
                System.out.println("Consumer take " + takeValue + "  size " + list.size());
                lock.notify();
            }
        }
    }

}
