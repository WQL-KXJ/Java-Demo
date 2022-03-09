package comshiro.spring_control;

import comshiro.bean.wql;
import comshiro.spring_service.wql_service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class login_contrllo {

    @Autowired
    wql_service service;
    @GetMapping("/loginout")
    public String loginout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return "redirect:login";
    }

@GetMapping({"/login","/"})
    public String login(){

    return "login";
}

@PostMapping("/login")
public String login1(@RequestParam("username") String a,@RequestParam("password") String b){

    Subject subject= SecurityUtils.getSubject();
    System.out.println(subject.hasRole("admin"));
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(a,b);
    try {
        subject.login(usernamePasswordToken);
        return "redirect:index";
    }catch (UnknownAccountException e){
        System.out.println("账号错误");
    }catch (IncorrectCredentialsException ae){
        System.out.println("密码错误");
    }

   return "redirect:login";
}


@GetMapping("/index")
    public  String index(){

    return "index";
}
    @GetMapping("/register")
    public  String register(){

        return "register";
    }

    @PostMapping("/register")
    public  String register_(wql s){

        boolean sd=service.insert_fq(s);
        if(sd){
            return "login";
        }else {
            return  "error";
        }

    }
}
