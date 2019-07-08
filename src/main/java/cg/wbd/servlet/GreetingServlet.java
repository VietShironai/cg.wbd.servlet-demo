package cg.wbd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuilder = new StringBuilder()
                .append("<form method=\"post\">")
                .append("    <label>")
                .append("        <input type=\"text\" name=\"name\">")
                .append("    </label>")
                .append("    <input type=\"submit\" value=\"Submit\">")
                .append("</form>");
        resp.setContentType("text/html");
        resp.getOutputStream().println(stringBuilder.toString());
    }
}
