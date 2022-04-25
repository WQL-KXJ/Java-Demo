package springcloud.service;


import com.cloud.commons.entities.payment;

public interface PaymentService {

    public boolean create(payment ment);
    public payment getPaymentByid(int id);

}
