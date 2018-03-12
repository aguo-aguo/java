package ccnt.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by aguo on 2018/3/10.
 */
public class ReentrantLoackTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {

        ReentrantLoackTest reentrantLoackTest = new ReentrantLoackTest();
        reentrantLoackTest.test();
        try {
            Thread.sleep(3000);
            reentrantLoackTest.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void signal() {
        try {
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("开始wait");
                    condition.await();
                    for (int i = 0; i < 5; i++) {
                        System.out.println("ThreadName=" + Thread.currentThread().getName()
                                + (" " + (i + 1)));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

    }

}
