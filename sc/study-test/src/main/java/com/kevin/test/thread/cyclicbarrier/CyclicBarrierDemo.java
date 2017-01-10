package com.kevin.test.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class CyclicBarrierDemo {

    public static class Solider implements Runnable {
        private String solider;
        private final CyclicBarrier cyclic;

        public Solider(String solider, CyclicBarrier cyclic) {
            this.solider = solider;
            this.cyclic = cyclic;
        }

        public void run() {
            try {
                cyclic.await();
                doWork();
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 100000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(solider + ":complete");
        }
    }

    public static class BarrierRun implements  Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        public void run() {
            if (flag) {
                System.out.println("capital: solder" + N  +",work done");
            } else {
                System.out.println("capital: solder" + N  +",come together");
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSolider = new Thread[N];
        boolean flag =  false;
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("come");
        for (int i = 0; i < N; ++i) {
            System.out.println("solider" + i + "bao dao");
            allSolider[i] = new Thread(new Solider("solider" + i, cyclic));
            allSolider[i].start();
        }
    }
}
