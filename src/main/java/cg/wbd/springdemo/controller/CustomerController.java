package cg.wbd.springdemo.controller;

import cg.wbd.springdemo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class CustomerController {
    @GetMapping("customers")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("customers/list.jsp");
        modelAndView.addObject("customers", new ArrayList<Customer>());
        return modelAndView;
    }
}
