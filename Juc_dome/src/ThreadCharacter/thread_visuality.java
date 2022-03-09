package ThreadCharacter;

public class thread_visuality {

    //共享变量
    private static  boolean a = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while(a) {
                System.out.println(a);
            }}).start();


        Thread.sleep(2000);

        new Thread(()->{
            a=false;
            System.out.println("已修改！");
        }).start();

    }

}
