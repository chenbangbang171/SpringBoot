package com.czj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {

        @RequestMapping("/interceptor/myinterceptor")
        public String myinterceptor(){

            System.out.println("myinterceptor");

            return "/index.html";
        }
}