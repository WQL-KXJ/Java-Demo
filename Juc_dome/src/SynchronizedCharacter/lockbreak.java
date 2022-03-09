package SynchronizedCharacter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockbreak {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable run = () -> {
            boolean b=false;
            try {
                 b = lock.tryLock(3, TimeUnit.SECONDS);
                if(b){
                    System.out.println(Thread.currentThread().getName() + "执行！");
                    Thread.sleep(88888);
                }else {
                    System.out.println("没有在指定时间获得锁，中断！");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                if(b){
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + "释放锁！");
            }}
        };

        Thread a = new Thread(run,"wql");
        a.start();

        Thread b =new Thread(run,"fq");
        b.start();
        System.out.println(b.getState());
    }
}
