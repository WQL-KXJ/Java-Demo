import com.fq.iprople;
import com.fq.prople;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test2 {
    public static void main(String[] args) throws IOException {

       InputStream stream= Resources.getResourceAsStream("mybatisconfig.xml");

        SqlSessionFactoryBuilder sessionFactoryBuilder= new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory=sessionFactoryBuilder.build(stream);

        SqlSession session=sqlSessionFactory.openSession(true);

        PageHelper.startPage(1,2);

        iprople iprople1= session.getMapper(iprople.class);

        Page<prople> proples = iprople1.select2();

        List<prople> result = proples.getResult();

        for(prople s:result){
            System.out.println("{"+s.getAge()+s.getName()+s.getXb()+s.getBmid()+"}");
        }




    }
}
