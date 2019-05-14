/**
 * @program: netty_lecture
 * @description:
 * @author: ZakL
 * @create: 2019-04-17 09:29
 **/
public class SynchronizedObjBlock implements Runnable {
    Object object = new Object();
    Object object2 = new Object();

    @Override
    public void run() {
        synchronized (object){
            System.out.println(Thread.currentThread().getName() + "占用 🔒OBJ一\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"釋放 🔒OBJ一\n");
        }
        synchronized (object2){
            System.out.println(Thread.currentThread().getName() + "占用 🔒OBJ二\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"釋放 🔒OBJ二\n");
        }
    }

    static SynchronizedObjBlock synchronizedObjBlock = new SynchronizedObjBlock();
    public static void main(String[] args) {
        Thread t1 = new Thread(synchronizedObjBlock,"线程一");
        Thread t2 = new Thread(synchronizedObjBlock,"线程二");
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finish");
    }
}