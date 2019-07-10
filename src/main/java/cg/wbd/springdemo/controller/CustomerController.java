package cg.wbd.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CustomerController {
    @GetMapping("customers")
    public String list() {
        return "customers/list.jsp";
    }
}
