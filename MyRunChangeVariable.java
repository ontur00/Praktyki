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
public class MyRunChangeVariable {

    private int[] tabInt;
    private Random random;
    private static int id;
    private Object lock = new Object();

    public MyRunChangeVariable(int[] tabWsk) {
        id++;
        tabInt = tabWsk;
        tabInt[0] = 0;

        if (random == null) {
            random = new Random(System.nanoTime());
        }
    }

//    @Override
//    public void run() {
//        synchronized (lock) {
//            while (true) {
//                long start = System.nanoTime();
//                increment(start);
//                decrement();
//            }
//        }
//    }
    public void increment(long startTime) throws InterruptedException {
        //increment
//        if (tabInt[0] == 0) {
//            tabInt[0] += 1;
//            //Sleep thread to Random time        
//            try {
//
//                this.wait(random.nextInt(10000));
//
//            } catch (InterruptedException ex) {
//                Logger.getLogger(MyRunChangeVariable.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            this.notify();
//        }
        while (true) {
            while (tabInt[0] == 0) {
                tabInt[0] += 1;
                Thread.sleep(random.nextInt(1000));

            }
        }
        
        //long end = System.nanoTime();
        //printIncrement(end - startTime);
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
