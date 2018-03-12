package ccnt.concurrent;

import java.util.concurrent.*;

/**
 * Created by aguo on 2018/3/7.
 */
public class CallableTest {

    public static void main(String[] args) {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(5000);
                return "hell callable";
            }
        };
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        try {
            System.out.println(futureTask.get(3000, TimeUnit.NANOSECONDS));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

}
