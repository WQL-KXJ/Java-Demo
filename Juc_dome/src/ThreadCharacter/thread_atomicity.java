package ThreadCharacter;

public class thread_atomicity {
    private  static int num;
    public static void main(String[] args) {

        Runnable runnable =()->{
            for(int a=0;a<1000;a++){
                num++;
                System.out.println(num);
            }
        };

        for(int i=0;i<5;i++){
            new Thread(runnable).start();
        }
    }
}
