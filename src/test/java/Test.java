/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-07 09:26
 **/
public class Test {

}

//class Singleton {
//    private volatile static Singleton singleton;
//
//    //不允许直接被外部调用构造方法
//    private Singleton() {
//
//    }
//    public static Singleton getSingleton(){
//        if (singleton == null) {
//            synchronized (Singleton.class) {
//                if (singleton == null) {
//                    singleton = new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }
//
//}

class Singleton {
    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
}

enum Sigleton{
    Instance
}