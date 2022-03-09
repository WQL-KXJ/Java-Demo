import  com.wqls.*;

import java.io.IOException;
import java.util.List;

public class test4 {
    public static void main(String[] args) throws IOException {

        fqbm a=new fqbm();
        List<bmswql> s=a.select();
        for(bmswql sd:s){
            System.out.print(sd);
        }

    }
}
