package ccnt.design.singleton;

/**
 * 饿汉式
 * Created by aguo on 2018/3/1.
 */
public class Singleton1 {
    private static Singleton1 ourInstance = new Singleton1();

    public static Singleton1 getInstance() {
        return ourInstance;
    }

    private Singleton1() {
    }
}
