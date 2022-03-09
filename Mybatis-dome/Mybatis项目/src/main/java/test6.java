import com.wqls.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test6 {
    public static void main(String[] args) throws IOException {

        InputStream stream = Resources.getResourceAsStream("mybatisconfig.xml");

        SqlSessionFactoryBuilder sessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sessionFactoryBuilder.build(stream);

        SqlSession session = sqlSessionFactory.openSession(true);

        imbwql iprople1 = session.getMapper(imbwql.class);

        List<bmswql> ad = iprople1.select();

        for(bmswql s : ad){
            System.out.println(s);

        }


    }

}
