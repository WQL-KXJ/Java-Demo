import com.wql.Iuser;
import com.wql.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class test1 {

    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybatisconfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(inputStream);

        SqlSession session = factory.openSession();

        Iuser iuser=session.getMapper(Iuser.class);

        int a=iuser.update(new user(19,"SB",101));
        System.out.print(a);
        session.commit();

        /*
        添加
        Boolean a=iuser.insert(new user(18,"SB",101));
        System.out.print(a);
        session.commit();

        删除
        iuser.delete(14);
        session.commit();

         更新
         iuser.update(new user(18,"LUOQIN",10));
        session.commit();

         查询
         List<user> list = iuser.findall();
        for (user a:list){
            System.out.println(a);
        }*/



    }
}
