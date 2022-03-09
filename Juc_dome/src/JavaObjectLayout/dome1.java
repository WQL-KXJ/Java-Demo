package JavaObjectLayout;

import org.openjdk.jol.info.ClassLayout;

public class dome1 {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        for(int i=1;i<=10;i++){
            stringBuffer.append(i);
        }
        System.out.println(stringBuffer);

    }
}
