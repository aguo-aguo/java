package ccnt.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by aguo on 2018/3/3.
 */
public class JdkInvocationHandler implements InvocationHandler {

    private IHelloWord target;

    JdkInvocationHandler(IHelloWord iHelloWord) {
        target = iHelloWord;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("jdk invoke before ");
        Object retVal = method.invoke(target, args);
        System.out.println("jdk invoke after");
        return retVal;
    }
}
