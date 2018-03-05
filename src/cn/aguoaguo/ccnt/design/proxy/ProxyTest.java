package cn.aguoaguo.ccnt.design.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by aguo on 2018/3/3.
 */
public class ProxyTest {

    public static void main(String[] args) {
        testJdkProxy();
    }

    private static void testJdkProxy() {

        IHelloWord iHelloWord = new IHelloWordImpl();
        JdkInvocationHandler jdkInvocationHandler = new JdkInvocationHandler(iHelloWord);
        IHelloWord proxy = (IHelloWord) Proxy.newProxyInstance(iHelloWord.getClass().getClassLoader()
                , new Class[]{IHelloWord.class}, jdkInvocationHandler);
        proxy.sayHello("world");

    }

}
