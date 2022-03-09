package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class test {


    @RequestMapping(value = "/",method = {RequestMethod.GET,RequestMethod.DELETE},params = {"wql=fq"},headers = {"user-agent"})
    public String index(){

        return "index";

    }

    @GetMapping("home")
    public String home(HttpServletRequest request){

        request.setAttribute("name","WQL");
        request.getParameter("name");
        return "home";
    }

    @GetMapping("wql")
    public ModelAndView wql(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("name","wql");

        modelAndView.setViewName("wql");

        return modelAndView;
    }

    @GetMapping("model")
    public String model(Model model){

        Map<String,Object> map = new HashMap();

        model.addAttribute("name","bilili");

        model.addAllAttributes(map);
        return "model";
    }

    @GetMapping("modelmap")
    public String modelmap(ModelMap modelmap){
        Map<String,Object> map = new HashMap();
        modelmap.addAllAttributes(map);
        modelmap.addAttribute("name","bilili");
        return "modelmap";
    }

    @GetMapping("map")
    public String map(Map<String,Object> map){
       map.put("name","bilili");
        return "map";
    }

    @GetMapping("session")
    public String session(HttpServletRequest request){
        //提供Request获取session对象
        HttpSession session = request.getSession();
        session.setAttribute("name","bilili");
        return "session";
    }
    @GetMapping("context")
    public String context(HttpSession session){
        //通过Session获取Context对象
        ServletContext servletContext = session.getServletContext();
        //存放数据
        servletContext.setAttribute("name","bilili");
        return "context";
    }
}
