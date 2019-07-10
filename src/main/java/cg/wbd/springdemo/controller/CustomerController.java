package cg.wbd.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @GetMapping("customers")
    public String list() {
        return "customers/list.jsp";
    }
}
