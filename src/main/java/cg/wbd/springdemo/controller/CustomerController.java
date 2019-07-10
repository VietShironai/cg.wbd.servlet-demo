package cg.wbd.springdemo.controller;

import cg.wbd.springdemo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {
    @GetMapping("customers")
    public String list(Model model) {
        model.addAttribute("customers", new ArrayList<Customer>());
        return "customers/list.jsp";
    }
}
