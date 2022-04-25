package springcloud.dao;


import com.cloud.commons.entities.payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public boolean insert(payment pay);

    public payment select(@Param("id") int id);

}
