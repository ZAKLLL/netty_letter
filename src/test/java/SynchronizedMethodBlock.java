/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-17 09:34
 **/
public class SynchronizedMethodBlock implements Runnable {

    public  synchronized void method() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在执行同步方法一");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"结束执行同步方法一");
    }
    public void method2() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"正在执行同步方法二");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"结束执行同步方法二");

    }
    @Override
    public void run() {
        try {
            method();
            method2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static SynchronizedMethodBlock synchronizedMethodBlock = new SynchronizedMethodBlock();
    public static void main(String[] args) {
        Thread t1 = new Thread(synchronizedMethodBlock);
        Thread t2 = new Thread(synchronizedMethodBlock);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finish");
    }
}