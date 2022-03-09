package logerwql;

import java.util.logging.Level;
import java.util.logging.Logger;

public class test {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger("logerwql.test");
        //日志的输出
        String name="傅晴";
        int age=18;
        logger.log(Level.INFO,"性名={0}，年龄={1}",new Object[]{name,age});
        System.out.println(logger.getHandlers().toString());
    }

}
