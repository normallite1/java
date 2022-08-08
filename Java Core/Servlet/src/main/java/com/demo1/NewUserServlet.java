package com.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class NewUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.write("<html><body>" +
                "<h1>Hello</h1>" +
                "    <form action=\"/login\" method=\"post\">\n" +
                "        User name:<label>\n" +
                "        <input name=\"login1\" type=\"text\">\n" +
                "    </label><br>\n" +
                "        Password:<label>\n" +
                "        <input name=\"pass1\" type=\"password\">\n" +
                "    </label>\n" +
                "        <input type=\"submit\">\n" +
                "    </form>\n" +
                "</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
