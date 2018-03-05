package ccnt.design.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by aguo on 2018/3/4.
 */
public class Hacker implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("hacker before coding");
//        Object retVal = proxy.invokeSuper(obj, args);
        Object retVal = method.invoke(obj, args);
        System.out.println("hacker after coding");
        return retVal;
    }
}
