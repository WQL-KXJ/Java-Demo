package comshiro.spring_service;

import comshiro.bean.wql;
import comshiro.mapper.wql_mapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wql_service")
public class wql_service  {
    @Autowired
    wql_mapper wqlMapper;

    public wql sele(String name){
        wql s=wqlMapper.select_pass(name);
        return s;
    }

    public  boolean  insert_fq(wql s){
        Md5Hash md5Hash = new Md5Hash(s.getRandom());
        s.setSalt("asd4a");
        s.setRandom(md5Hash.toHex());
        boolean sd=wqlMapper.insert_pass(s);
        return sd;

    }

}
