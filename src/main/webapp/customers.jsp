<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List customers = (List) request.getAttribute("customers");
%>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
There are <%= customers.size() %> customers in list.
</body>
</html>
