package ccnt.concurrent;

import java.util.concurrent.*;

/**
 * Created by aguo on 2018/3/9.
 */
public class NewThread {

    public static void main(String[] args) {

//        runExtendsThread();

        runRunnableThread();

        runCallableThread();

    }

    private static void runCallableThread() {

        ExecutorService executorService = new ThreadPoolExecutor(4,
                4, 0, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable thread";
            }
        });

        try {
            System.out.println(future.get(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
            try {
                executorService.awaitTermination(3,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void runRunnableThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable thread");
            }
        }).start();
    }

    public static void runExtendsThread() {
        new MyThread().start();
    }

    static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("extend thread run");
        }
    }

}
