package springcloud.service.serviceimpl;

import com.cloud.commons.entities.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springcloud.dao.PaymentDao;
import springcloud.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;



    @Transactional
    public boolean create(payment ment) {

        boolean insert = paymentDao.insert(ment);

        return insert;
    }


    public payment getPaymentByid(int id) {

        payment select = paymentDao.select(id);

        return select;
    }
}
