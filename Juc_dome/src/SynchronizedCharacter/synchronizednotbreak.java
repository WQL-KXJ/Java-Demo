package SynchronizedCharacter;

public class synchronizednotbreak {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        //1,定义一个run对象
        Runnable run = ()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "进入了代码块！");
                try {
                    //休眠80000秒
                    Thread.sleep(80000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //启动线程a
        Thread a = new Thread(run,"wql");
        a.start();

        //1000毫秒后在启动b线程
        Thread.sleep(1000);

        Thread b =new Thread(run,"fq");
        b.start();
        //因为a执行时间很久，把b线程放弃执行
        b.interrupt();
        //查看b线程的状态
        System.out.println(b.getState());
    }
}
