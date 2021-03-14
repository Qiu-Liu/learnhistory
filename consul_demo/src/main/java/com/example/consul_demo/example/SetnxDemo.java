package com.example.consul_demo.example;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * 手动完成redis分布式锁
 */
public class SetnxDemo {

    @Resource
    private StringRedisTemplate redisTemplate;

    @Resource
    private Redisson redisson;

    private final static String redisKey="redisKey";


    public void setRedisLock(){
        String threadId = String.valueOf(Thread.currentThread().getId());
        try {

            //使用setnx命令加锁,10s超时
            Boolean redisValue = redisTemplate.opsForValue().setIfAbsent(redisKey, threadId, 10, TimeUnit.SECONDS);
            if (!redisValue){
                throw new RuntimeException("系统繁忙");
            }
            //执行业务代码

        }finally {
            //1、此处不是原子性
            //2、如果一个线程执行时间较长进行的时间为15s，设置的锁会超时，锁失效不能对下一个线程加锁。解决方案:锁续命
            //锁续命：开一定时任务每隔5s，检测锁是否存在，如果存在重新设定锁时间为初始值10s。
            //redisson解决此问题，redison底层使用的lua命令保证每个命令的原子性，redisson源码中添加的锁检测机制定时任务，每隔设置时间的1/3重新加锁。
            if (threadId.equals(redisTemplate.opsForValue().get(redisKey))){
                redisTemplate.delete(redisKey);
            }
        }

    }
}
