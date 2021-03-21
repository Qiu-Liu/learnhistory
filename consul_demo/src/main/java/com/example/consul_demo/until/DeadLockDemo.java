package com.example.consul_demo.until;

/**
 * 简单线程死锁
 */
public class DeadLockDemo {
    //资源1
    private static Object resource1= new Object();

    //资源2
    private static Object resource2= new Object();

    /**
     * 线程1对资源1进行加锁，加锁完成后，资源1休眠
     * 同时线程2对资源2进行加锁，加锁后休眠
     * 线程1休眠后访问资源2，线程2休眠后访问资源1，都必须等待对方释放锁，造成死锁
     */
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (resource1){
                System.out.println(Thread.currentThread()+"对资源1加锁");
                try {
                    System.out.println("线程1休眠");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource2){
                    System.out.println(Thread.currentThread()+"对资源2加锁");
                }
            }

        },"线程1").start();

        new Thread(()->{
            synchronized (resource2){
                System.out.println(Thread.currentThread()+"对资源2加锁");

                try {
                    System.out.println("线程2休眠");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (resource1){
                    System.out.println(Thread.currentThread()+"对资源1加锁");
                }
            }



        },"线程2").start();

    }
}
