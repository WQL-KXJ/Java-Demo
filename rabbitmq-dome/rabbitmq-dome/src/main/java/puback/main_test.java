package puback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class main_test {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        puback_publish puback_publish = new puback_publish();

        String time = puback_publish.asynchronous_un_upback();

        System.out.println(time);

    }
}
