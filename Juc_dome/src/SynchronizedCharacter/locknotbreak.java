package SynchronizedCharacter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class locknotbreak {

   private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Runnable run = () -> {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "执行！");
            try {
                Thread.sleep(88888);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁！");
        };

        Thread a = new Thread(run,"wql");
        a.start();

        Thread.sleep(1000);

        Thread b =new Thread(run,"fq");
        b.start();
        b.interrupt();//中断线程
        System.out.println(b.getState());
    }
}
