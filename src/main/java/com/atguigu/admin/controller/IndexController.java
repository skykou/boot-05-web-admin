package com.atguigu.admin.controller;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.impl.CityService;
import com.atguigu.admin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author zhangtao
 * @date 2022/5/23 - 21:39
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

   // @Autowired
    StringRedisTemplate stringRedisTemplate;

    @ResponseBody
    @GetMapping("/city")
    public City getById1(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/city1")
    public City saveCity(){
        City city=new City();
        city.setName("fcf");
        city.setCountry("sdcsd");
        city.setState("cdc");
        cityService.saveCity(city);
        return city;
    }

//    @ResponseBody
//    @GetMapping("/user")
//    public User getById(@RequestParam("id") Long id){
//
//        return userService.getUserById(id);
//    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from student", Long.class);
        return aLong.toString();
    }

    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            ///把登陆成功的用户保存起来
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;重定向防止表单重复提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        log.info("当前方法：{}","mainPage");
//        //是否登录
//        Object loginUser = session.getAttribute("loginUser");
//        if(loginUser!=null){
//            return "index";
//        }else{
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String s = opsForValue.get("/main.html");
        String s1 = opsForValue.get("/sql");
        model.addAttribute("mainCount",s);
        model.addAttribute("sqlCount",s1);
        return "index";
    }
}
