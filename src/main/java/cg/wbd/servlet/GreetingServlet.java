package cg.wbd.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameParam = req.getParameter("name");
        if (nameParam == null || nameParam.isEmpty()) {
            resp.getOutputStream().println("Hello world!");
        } else {
            resp.getOutputStream().println("Hello " + nameParam + "!");
        }
        resp.getOutputStream().println("<br/>");
        resp.getOutputStream().println("<a href=\"/greeting\">Back</a>");
        resp.setContentType("text/html");
    }
}
