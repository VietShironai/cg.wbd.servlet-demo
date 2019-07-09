<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<%
    List customers = (List) request.getAttribute("customers");
%>
There are <%= customers.size() %> customers in list.
</body>
</html>
