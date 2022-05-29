package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtao
 * @date 2022/5/25 - 10:56
 */
@RestController
public class StudentController {
    private List<Student> students=new ArrayList<Student>();
    @RequestMapping("/getStudents")
    public List<Student> getStudents(){

        students.add(new Student(1, "张三",18, "男", "湖南长沙"));
        students.add(new Student(2, "李四",19, "女", "湖南湘潭"));
        students.add(new Student(3, "王五",20, "女", "湖南益阳"));
        students.add(new Student(4, "赵六",21, "男", "湖南邵阳"));
        students.add(new Student(5, "二麻子",22, "女", "湖南衡阳"));
        return students;
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student){
        students.add(student);
        return "true";
    }
}
