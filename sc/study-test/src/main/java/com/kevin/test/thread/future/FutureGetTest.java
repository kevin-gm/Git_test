package com.kevin.test.thread.future;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2016/12/20 0020.
 */
public class FutureGetTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 20; i++) {
            final int s = i;
            Future<String> future = exec.submit(new Callable<String>() {
                public String call() throws Exception {
                    Thread.sleep(2000);
                    return s + "doing";
                }
            });
            if(future.get() != null) {
                System.out.println(i + "get result:");
                System.out.println(future.get());
            }
        }
        exec.shutdown();
    }
}