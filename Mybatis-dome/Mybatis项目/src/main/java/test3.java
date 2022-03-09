import com.duobiao.Iwqluser;
import com.duobiao.wqluser;
import com.fq.prople;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class test3 {
    public static void main(String[] args) throws IOException {
        //读取主配置文件
        InputStream stream= Resources.getResourceAsStream("mybatisconfig.xml");

        //Sqlsession工厂创建器
        SqlSessionFactoryBuilder sessionFactoryBuilder= new SqlSessionFactoryBuilder();

        //创建SqlSession工厂
        SqlSessionFactory sqlSessionFactory=sessionFactoryBuilder.build(stream);

        //获取SqlSession1对象和SqlSession2对象
        SqlSession session1=sqlSessionFactory.openSession();
        SqlSession session2=sqlSessionFactory.openSession();

        //通过SqlSession获取两个代理接口
        Iwqluser iprople1= session1.getMapper(Iwqluser.class);
        Iwqluser iprople2= session2.getMapper(Iwqluser.class);

        //查询1
        wqluser wqluser1 =  iprople1.select2(1);
        System.out.println(wqluser1);

        //关闭session1会话，让该缓存中的数据进入到二级缓存中
        session1.close();

        //查询2
        wqluser wqluser2 =  iprople2.select2(1);
        System.out.println(wqluser2);
        session2.close();

         }
}
