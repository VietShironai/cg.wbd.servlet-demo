package cg.wbd.springdemo.controller;

import cg.wbd.springdemo.model.Customer;
import cg.wbd.springdemo.service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerController extends HttpServlet {
    private static final String EDIT = "edit";
    private static final String NO_ACTION = "";

    private CustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        switch (getAction(req)) {
            case EDIT:
                showDetails(req, resp);
                break;
            case NO_ACTION:
                showList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        customerService.save(parseCustomer(req));
        showUpdateSuccess(req, resp);
    }

    private String getAction(HttpServletRequest req) {
        String action = req.getParameter("action");
        return action == null ? NO_ACTION : action.toLowerCase();
    }

    private Customer parseCustomer(HttpServletRequest req) {
        Long id = Long.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Customer customer = new Customer(name, email, address);
        customer.setId(id);

        return customer;
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customers", customerService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customers/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long customerId = Long.valueOf(req.getParameter("id"));
        req.setAttribute("customer", customerService.find(customerId));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customers/details.jsp");
        dispatcher.forward(req, resp);
    }

    private void showUpdateSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customers/update-success.jsp");
        dispatcher.forward(req, resp);
    }

}
