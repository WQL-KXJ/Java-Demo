package SynchronizedCharacter;

public class synchronizedreentry {

    public static void main(String[] args) {
       reentry r =  new reentry();
        new Thread(r,"wql").start();
        new Thread(r,"fq").start();

    }
}

class reentry implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            System.out.println(Thread.currentThread().getName()+"进入了同步代码块一！");
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+"进入了同步代码块二！");
            }
        }
    }
}

