package ccnt.jvm;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * Created by aguo on 2018/1/17.
 */
public class MemLeak {

    void method() {
        Vector vector = new Vector();
        for (int i = 1; i < 100; i++) {
            Object object = new Object();
            vector.add(object);
            object = null; //并不会改变vector数组对原object的引用
        }
        System.out.println(vector.size());
        //...对vector的操作

        //vector=null; //解决方法:尽早释放

        //...与vector无关的其他操作
    }

    public static void main(String[] args) {

//        MemLeak memLeak=new MemLeak();
//        memLeak.method();

        Set<Object> set = new HashSet<>();
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();
        set.add(o1);
        set.add(o2);
        set.add(o3);
        System.out.println("size: " + set.size());
        o1 = null; //o1引用的地址改变了,所以无法remove
        set.remove(o1);
        System.out.println("size: " + set.size());
        Object o4=null;
        set.add(o4); //hashset允许添加null
        System.out.println("size: " + set.size());
        Object o5=null;//和o4一样，指向null，所以不会重复添加
        set.add(o5);
        System.out.println("size: " + set.size());
        System.out.println("size: " + set.contains(o1));
    }

}
