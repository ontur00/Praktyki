package Wielowatkowosc;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Watek ktory ma za zadanie do tablicy tab[0] odejmować oraz dodawać wartość 1
 * gdzie wynik końcowy powinien byc = 0
 *
 * @author Radosław
 */
public class MyRunChangeVariable implements Runnable {

    private int[] tabInt;
    private Random random;
    private static int id;

    public MyRunChangeVariable(int[] tabWsk) {
        id++;
        tabInt = tabWsk;
        tabInt[0] = 0;

        if (random == null) {
            random = new Random(System.nanoTime());
        }
    }

    @Override
    public void run() {

        while (true) {
            synchronized (tabInt) {
                long start = System.nanoTime();
                increment(start);
                decrement();
            }
        }
    }

    public synchronized void increment(long startTime) {
        //increment
        if (tabInt[0] == 0) {
            tabInt[0] += 1;
            //Sleep thread to Random time        
            try {

                this.wait(random.nextInt(100));

            } catch (InterruptedException ex) {
                Logger.getLogger(MyRunChangeVariable.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.notify();
        }
        long end = System.nanoTime();
        printIncrement(end - startTime);
    }

    private void decrement() {
        long start = 0;

        if (tabInt[0] == 1) {
            tabInt[0] = 0;

        }

        long end = System.nanoTime();
        if ((end - start) < end) {
            printDecrement(end - start);
        } else {
            printDecrement(end);
        }
    }

    private void printDecrement(long time) {
        System.out.println("Watek " + id + " Decrement  " + tabInt[0]);
    }

    private void printIncrement(long time) {
        System.out.println("Watek " + id + " Increment  " + tabInt[0] + "   Time " + (double) (time / 1000000000.0) + " sec");
    }
}
