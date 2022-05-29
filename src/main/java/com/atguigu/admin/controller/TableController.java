package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author zhangtao
 * @date 2022/5/24 - 10:37
 */
@Controller
public class TableController {

    @Autowired
    private UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i=1/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id,
                             @RequestParam(value="pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value="pn",defaultValue = "1")Integer pn,Model model){
//        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
//                new User("lisi", "123456"),
//                new User("hh", "123456"),
//                new User("hhee", "123456"),
//                new User("haha", "123456"));
//        model.addAttribute("users",users);
//        if(users.size()>3){
//            throw new UserTooManyException();
//        }
        List<User> list = userService.list();
//        model.addAttribute("users",list);
        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);
        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();

        model.addAttribute("page",page);
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
