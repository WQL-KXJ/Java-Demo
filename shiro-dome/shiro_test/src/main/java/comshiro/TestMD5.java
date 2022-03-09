package comshiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import sun.security.provider.MD5;

public class TestMD5 {

    public static void main(String[] args) {
        /*
        Md5Hash在MD5的基础上又进行了散列处理
        Md5Hash hash = new Md5Hash();这种处理方式不正确
        hash.setBytes("123456".getBytes());
        String a = hash.toHex();
        System.out.println(a);
        */
         //MD5标准用法 MD5是单独的类
         Md5Hash md5Hash = new Md5Hash("18");
        System.out.println(md5Hash.toHex());

         //使用MD5 + Salt处理
        Md5Hash hash=  new Md5Hash("123456","123456");
        System.out.println(hash.toHex());

        //MD5 +Salt + hash散列
        Md5Hash a=new Md5Hash("123456","123456",123);//这里散列123次
        System.out.println(a.toHex());


    }

}
