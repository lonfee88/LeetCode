/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package BlockingQueue;

import java.util.concurrent.Semaphore;

/**
 *
 * https://blog.csdn.net/java2000_net/article/details/3997449
 *
 * @author longfei.wlf
 * @version $Id: TestSemaphore.java, v 0.1 2020-05-15 11:18 PM longfei.wlf Exp $$
 */
public class TestSemaphore {
    /**
     * �ֿ�
     *
     * @author ������(laozizhu.com)
     */
    static class Warehouse {
        // ������
        final Semaphore notFull  = new Semaphore(10);
        // �ǿ���
        final Semaphore notEmpty = new Semaphore(0);
        // ������
        final Semaphore mutex    = new Semaphore(1);
        // �������
        final Object[]  items    = new Object[10];
        int             putptr, takeptr, count;

        /**
         * ����Ʒ����ֿ�.<br>
         *
         * @param x
         * @throws InterruptedException
         */
        public void put(Object x) throws InterruptedException {
            // ��֤����
            notFull.acquire();
            // ��֤����ͻ
            mutex.acquire();
            try {
                // ���ӿ��
                items[putptr] = x;
                if (++putptr == items.length)
                    putptr = 0;
                ++count;
            } finally {
                // �˳�������
                mutex.release();
                // ���ӷǿ��ź����������ȡ��Ʒ
                notEmpty.release();
            }
        }

        /**
         * �Ӳֿ��ȡ��Ʒ
         *
         * @return
         * @throws InterruptedException
         */
        public Object take() throws InterruptedException {
            // ��֤�ǿ�
            notEmpty.acquire();
            // ������
            mutex.acquire();
            try {
                // ���ٿ��
                Object x = items[takeptr];
                if (++takeptr == items.length)
                    takeptr = 0;
                --count;
                return x;
            } finally {
                // �˳�������
                mutex.release();
                // ���ӷ������ź��������������Ʒ
                notFull.release();
            }
        }
    }

    // �ֿ�
    static Warehouse buffer = new Warehouse();

    // �����ߣ���������
    static class Producer implements Runnable {
        static int num = 1;

        @Override
        public void run() {
            int n = num++;
            while (true) {
                try {
                    buffer.put(n);
                    System.out.println(">" + n);
                    // �ٶȽϿ졣��Ϣ10����
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // �����ߣ��������
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("<" + buffer.take());
                    // �ٶȽ�������Ϣ1000����
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        // �����߳�
        for (int i = 0; i <= 3; i++) {
            // ������
            new Thread(new Producer()).start();
            // ������
            new Thread(new Consumer()).start();
        }
    }
}