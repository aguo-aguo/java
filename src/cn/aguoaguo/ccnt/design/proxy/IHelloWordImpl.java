package cn.aguoaguo.ccnt.design.proxy;

/**
 * Created by aguo on 2018/3/3.
 */
public class IHelloWordImpl implements IHelloWord {


    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
