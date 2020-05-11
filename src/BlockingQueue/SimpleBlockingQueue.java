/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package BlockingQueue;

/**
 *
 * 手写阻塞队列BlockQueue--大厂面试常考题
 * 
 * https://blog.csdn.net/NathanniuBee/article/details/102955267
 *
 * @author longfei.wlf
 * @version $Id: SimpleBlockingQueue.java, v 0.1 2020-05-10 1:50 PM longfei.wlf Exp $$
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 仿照阻塞队列，实现自己的阻塞队列。
 * 中间会使用到Lock接口,ReentrantLock，Condition
 */
public class SimpleBlockingQueue {

    //队列容器
    private List<Integer> container = new ArrayList<>();
    private Lock          lock      = new ReentrantLock();
    //Condition
    //  队列为空
    private Condition     isNull    = lock.newCondition();
    // 队列已满
    private Condition     isFull    = lock.newCondition();
    private volatile int  size;
    private volatile int  capacity;

    SimpleBlockingQueue(int cap) {
        this.capacity = cap;
    }

    public void add(int data) {
        // java doc 推荐lock放在try之前
        lock.lock();
        try {
            try {
                while (size >= capacity) {
                    System.out.println("队列已满，释放锁，等待消费者消费数据");
                    isFull.await();
                }
            } catch (InterruptedException e) {
                isFull.signal();
                e.printStackTrace();
            }
            ++size;
            container.add(data);
            isNull.signal();
        } finally {
            lock.unlock();
        }
    }

    public int take() {
        // java doc 推荐lock放在try之前
        lock.lock();
        try {
            try {
                while (size == 0) {
                    System.out.println("阻塞队列空了，释放锁，等待生产者生产数据");
                    isNull.await();
                }
            } catch (InterruptedException e) {
                isNull.signal();
                e.printStackTrace();
            }
            --size;
            int res = container.get(0);
            container.remove(0);
            isFull.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SimpleBlockingQueue queue = new SimpleBlockingQueue(5);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.add(i);
                System.out.println("拉个：" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (;;) {
                System.out.println("屎壳郎开始工作，消费：" + queue.take());
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
