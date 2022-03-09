package wql;

import bean.UserAdress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

@Service
public class OrderAdress {

    @Autowired
    UserService userservice;

    public void init(){

        UserAdress userAdress = userservice.getbean().get(1);

        System.out.println(userAdress);
    }

}
