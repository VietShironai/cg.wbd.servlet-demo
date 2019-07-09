package cg.wbd.springdemo.controller;

import cg.wbd.springdemo.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController extends HttpServlet {
    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            req.setAttribute("customers", customerService.findAll());
            RequestDispatcher dispatcher = req.getRequestDispatcher("customers.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
