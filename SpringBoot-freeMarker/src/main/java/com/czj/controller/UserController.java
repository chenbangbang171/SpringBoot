package com.czj.controller;

import com.czj.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class UserController {


    @RequestMapping("findAll")
    public String findAll(Model model) {

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "jack", 18, "郑州二七"));
        students.add((new Student(1001, "张三", 20,"金水区")));

        students.add(new Student(2, "rose", 19, "郑州中原"));
        students.add(new Student(3, "tom", 20, "郑州金水"));

        model.addAttribute("users", students);

        return "/list";
    }

    @RequestMapping("findById")
    public String findById(Model model, String uid) {
        System.out.println(uid);

        if (uid.equals("1001")) {
            Student user = new Student(1001, "张三", 20,"金水区");
            model.addAttribute("user", user);
        }

        return "/queryOne";

    }

}