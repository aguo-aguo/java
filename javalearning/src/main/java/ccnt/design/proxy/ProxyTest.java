package ccnt.design.proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by aguo on 2018/3/3.
 */
public class ProxyTest {

    public static void main(String[] args) throws IOException {
//        testJdkProxy();

//        testCglibProxy();

    }

    private static void testCglibProxy() {

        Hacker hacker = new Hacker();
        JavaProgrammer javaProgrammer = new JavaProgrammer();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Programmer.class);
        enhancer.setCallbacks(new Callback[]{hacker, javaProgrammer});
        enhancer.setCallbackFilter(new CallbackFilter() {
            //根据不同的方法选择不同的代理方法
            @Override
            public int accept(Method method) {
                if (method.getName().equals("code")) return 1;
                return 0;
            }
        });
        Programmer proxy = (Programmer) enhancer.create();
        proxy.code();

    }

    private static void testJdkProxy() {

        IHelloWord iHelloWord = new IHelloWordImpl();
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(iHelloWord);
        IHelloWord proxy = (IHelloWord) Proxy.newProxyInstance(iHelloWord.getClass().getClassLoader()
                , new Class[]{IHelloWord.class}, jdkInvocationHandler);
        proxy.sayHello("world");

    }

}
