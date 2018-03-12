package ccnt.concurrent;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by aguo on 2018/3/10.
 */
public class CountDownLathcTest {

    private static int count = 10;

    private static CountDownLatch countDownLatch = new CountDownLatch(count);

    public static void main(String[] args) {

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (countDownLatch.await(2, TimeUnit.SECONDS))
                            System.out.println("countDownLatch" + finalI + " over peaceful!");
                    } catch (InterruptedException e) {
                        System.out.println("countDownLatch" + finalI + " timeout!");
                    }
                }
            }).start();

        }

        for (int i = 0; i < count + 1; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Thread" + finalI + " start!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }

    }

}
