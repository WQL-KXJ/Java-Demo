package comshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import comshiro.bean.wql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface wql_mapper extends BaseMapper<wql> {

    @Select("select * from fq where name=#{username}")
    public wql select_pass(String username);

    @Insert("insert into fq (name,random,salt) values(#{name},#{random},#{salt})")
    public boolean insert_pass(wql w);

}
