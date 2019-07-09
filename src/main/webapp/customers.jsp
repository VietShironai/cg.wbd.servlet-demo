<%@ page import="cg.wbd.springdemo.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="cg.wbd.springdemo.service.CustomerService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<%
    CustomerService customerService = new CustomerService();
    List<Customer> customers = customerService.findAll();
%>
There are <%= customers.size()%> customers in list.
</body>
</html>
