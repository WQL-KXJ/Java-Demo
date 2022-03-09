import com.testsw.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class test7 {
    public static void main(String[] args) throws IOException {


        InputStream stream = Resources.getResourceAsStream("mybatisconfig.xml");

        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(stream);

        SqlSession session = sqlSessionFactory.openSession(true);

        fq123 iprople1 = session.getMapper(fq123.class);

        wql123 a=iprople1.select(1);
        System.out.println(a);
    }
}
