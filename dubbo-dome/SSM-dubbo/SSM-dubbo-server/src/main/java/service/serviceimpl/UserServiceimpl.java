package service.serviceimpl;

import bean.UserAdress;
import org.apache.dubbo.config.annotation.Service;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserServiceimpl implements UserService {
    public List<UserAdress> getbean() {

        UserAdress wql1 = new UserAdress("WQL", "湖南衡阳！");

        UserAdress wql2 = new UserAdress("FQ","深圳");

        List<UserAdress> list = new ArrayList<UserAdress>();

        list.add(wql1);
        list.add(wql2);

        return list;
    }
}
