/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package thread;

/**
 * @author longfei.wlf
 * @version $Id: PrintNumberIncrInSynchronized.java, v 0.1 2020年04月04日 10:57 PM longfei.wlf Exp $
 */
public class PrintNumberIncrInSynchronized {
    private static Object object = new Object();
    private static int    n      = 0;

    public static void main(String[] args) {
                new Thread(() -> {
                    while (n < 10) {
                        synchronized (object) {
                            if ((n & 1) == 1) {
                                System.out.println(Thread.currentThread().getName() + ":" + n++);
                            }
                        }
                    }
                }, "奇数").start();

                new Thread(() -> {
                    while (n < 10) {
                        synchronized (object) {
                            if ((n & 1) == 0) {
                                System.out.println(Thread.currentThread().getName() + ":" + n++);
                            }
                        }
                    }
                }, "偶数").start();
    }

}