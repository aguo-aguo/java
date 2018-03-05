package ccnt.design.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by aguo on 2018/3/4.
 */
public class JavaProgrammer implements MethodInterceptor {


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("java programmer before coding");
        Object retVal = proxy.invokeSuper(obj, args);
        System.out.println("java programmer after coding");
        return retVal;
    }
}
