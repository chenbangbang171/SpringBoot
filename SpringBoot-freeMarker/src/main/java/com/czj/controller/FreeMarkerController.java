package com.czj.controller;

import com.czj.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("freemarker")
public class FreeMarkerController {

    @RequestMapping("/student")
    public String hello(Model model) throws Exception {

        //创建List集合获取多个元素
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "jack", 18, "郑州二七"));
        students.add(new Student(2, "rose", 19, "郑州中原"));
        students.add(new Student(3, "tom", 20, "郑州金水"));

        model.addAttribute("students",students);

        return "/student";
    }


    //生成静态页面的方法
    @RequestMapping("createHtml")
    @ResponseBody
    public String createHtml()throws Exception{
        //获取配置对象
        Configuration configuration = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        //设置字符集
        configuration.setDefaultEncoding("utf-8");

        //设置加载的模版目录
        configuration.setDirectoryForTemplateLoading(new File("D:/ftl"));
        //创建List集合获取多个元素
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"张三",18,"北京"));
        students.add(new Student(2,"李四",19,"上海"));
        students.add(new Student(3,"王五",20,"广州"));

        //使用map集合加载数据
        HashMap<String,ArrayList> map = new HashMap<>();
        map.put("students",students);

        //创建输出流对象
        FileWriter fileWriter = new FileWriter(new
                File("D:/ftl/student.html"));

        //获取加载的模板
        Template template = configuration.getTemplate("student.ftl");
        //生成html文件
        template.process(map,fileWriter);
        //关流
        fileWriter.close();

        return "success";
    }
}
