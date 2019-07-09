<%@ page import="cg.wbd.springdemo.model.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("customer");
%>
<html>
<head>
    <title>Customer Details</title>
</head>
<body>
<form>
    <fieldset>
        <legend>Customer Details</legend>
        <table>
            <tr>
                <td><label for="name">Name:</label></td>
                <td>
                    <input type="text" name="name" id="name" value="<%= customer.getName() %>">
                </td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td>
                    <input type="text" name="email" id="email" value="<%= customer.getEmail() %>">
                </td>
            </tr>
            <tr>
                <td><label for="address">Address:</label></td>
                <td>
                    <input type="text" name="address" id="address" value="<%= customer.getAddress() %>">
                </td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Update"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
