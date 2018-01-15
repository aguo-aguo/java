package cn.aguoaguo.ccnt.jvm;

/**
 * Xss调整占栈内存容量，Xoss参数是无效的
 * Created by aguo on 2018/1/15.
 */
public class JavaVMstatckSOF {

    private int stackLength = 1;

    private void stackLeack() {
        stackLength++;
        stackLeack();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMstatckSOF javaVMstatckSOF = new JavaVMstatckSOF();
        try {
            javaVMstatckSOF.stackLeack();
        } catch (Throwable e) {
            System.out.println("stack Length: " + javaVMstatckSOF.stackLength);
            throw e;
        }


    }
}
