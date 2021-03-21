package com.example.consul_demo.until;

/**
 * 单例模式
 * 私有的构造方法
 * 共有的获得对象的方法
 */
public class SingleDemo {

    //volatile保证可见性和有序性，线程在操作single对象时，会及时从工作内存中刷新到主内存，其他线程可及时获得single改变后的值
    //volatile会锁定这块内存区域，，并写回到主内存。将引用该内存地址的数据失效(MESI协议会)，其他线程会重新读取主内存数据
    private static volatile SingleDemo single;

    //私有的构造方法
    private SingleDemo(){

    }
    //并发编程三大共性：可见性，有序性、原子性
    public static SingleDemo getSingle(){

        if (single==null){
            //synchronized保证原子性
            //synchronized锁主要作用在在对象头，记录线程id、锁膨胀、轻量级锁、重量级锁
            synchronized (SingleDemo.class){
                if (single==null){
                    single=new SingleDemo();
                }

            }
        }


        return single;
    }
}
