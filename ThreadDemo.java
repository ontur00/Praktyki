package Wielowatkowosc;

public class ThreadDemo {

    public static void main(String[] args) {
        Shared s = new Shared();
        new Producer(s).start();
        new Consumer(s).start();
    }
}

class Shared {

    private char c = '\u0000';
    private boolean writeable = true;

    synchronized void setSharedChar(char c) {
        while (!writeable) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        this.c = c;
        writeable = false;
        notifyAll();
        System.out.println("setSharedChar notify() called - still in synchronized block.");
    }

    synchronized char getSharedChar() {
        while (writeable) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        writeable = true;
        notifyAll();
        System.out.println("getSharedChar notify() called - still in synchronized block.");

        return c;
    }
}

class Producer extends Thread {

    private Shared s;

    Producer(Shared s) {
        this.s = s;
    }

    public void run() {
        System.out.println("Starting producer thread.");
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.println("Producer thread getting ready to create a char.");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }

            s.setSharedChar(ch);
            System.out.println(ch + " produced by producer.");
        }
    }
}

class Consumer extends Thread {

    private Shared s;

    Consumer(Shared s) {
        this.s = s;
    }

    public void run() {
        System.out.println("Starting consumer thread.");
        char ch;

        do {
            System.out.println("Consumer thread getting ready to read a char.");
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }

            ch = s.getSharedChar();
            System.out.println(ch + " consumed by consumer.");
        } while (ch != 'Z');
    }
}
