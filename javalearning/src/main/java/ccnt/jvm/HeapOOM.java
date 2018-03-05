package ccnt.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆内存溢出
 * Created by aguo on 2018/1/15.
 */
public class HeapOOM {

    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();

        while (true){
            list.add(new OOMObject());
//            System.gc();
        }
    }

}
