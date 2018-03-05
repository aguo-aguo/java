package ccnt.design.singleton;

/**
 * 懒汉式
 * Created by aguo on 2018/3/1.
 */
public class Singleton2 {

    //禁止指令重排序，在new操作未结束之前，其他线程无法访问instance
    private static volatile Singleton2 intance = null;

    private Singleton2() {
    }

    public static Singleton2 getIntance() {
        if (intance == null) {
            synchronized (Singleton2.class) {
                if (intance == null)
                    intance = new Singleton2();
            }
        }
        return intance;
    }

}
