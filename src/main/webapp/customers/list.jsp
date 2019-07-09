<%@ page import="cg.wbd.springdemo.model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
%>
<html>
<head>
    <title>Customer List</title>
    <style>
        table {
            border: 1px solid #000;
        }

        th, td {
            border: 1px dotted #333;
        }
    </style>
</head>
<body>
There are <%= customers.size() %> customers in list.

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <% for (Customer c : customers) {%>
    <tr>
        <td>
            <%=c.getName()%>
        </td>
        <td>
            <%=c.getEmail()%>
        </td>
        <td>
            <%=c.getAddress()%>
        </td>
        <td>
            <a href="<%= "/customers?action=edit&id=" + c.getId() %>">Edit</a>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
</body>
</html>
