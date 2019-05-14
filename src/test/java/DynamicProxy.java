import javax.annotation.processing.SupportedSourceVersion;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-05 10:34
 **/
public class DynamicProxy implements InvocationHandler {

    private Tinteface tinteface;

    DynamicProxy(Tinteface tinteface) {
        this.tinteface = tinteface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //若在invoke()函数中使用proxy调用方法会陷入死循环
        System.out.println("动态代理开始");
        //invoke所需参数为需要代理的目标类，目标类方法所需参数
        return method.invoke(tinteface, args);
    }

    public static void main(String[] args) throws IOException {
        TEEEE3 teeee3 = new TEEEE3();
        DynamicProxy dynamicProxy = new DynamicProxy(teeee3);
        Tinteface tinteface = (Tinteface) Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(), new Class[]{Tinteface.class},dynamicProxy );
        String s = tinteface.echo("张三");
        System.out.println(s);
    }
}
