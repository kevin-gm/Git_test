package com.kevin.test.lambda;

/**
 * Created by Administrator on 2016/12/16 0016.
 */
public class First {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("aaa");
            }
        }).start();


    }
}
