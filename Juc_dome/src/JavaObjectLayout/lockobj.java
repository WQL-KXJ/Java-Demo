package JavaObjectLayout;

import org.openjdk.jol.info.ClassLayout;

public class lockobj extends Thread {

    private  static Object lock = new Object();
    @Override
    public void run() {
        for (int a=1;a<10;a++){
        synchronized (lock){
            System.out.println(ClassLayout.parseInstance(lock).toPrintable());
        }
        }
    }
}
