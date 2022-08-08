package com.demo1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {
    static final String TEMPLATE = "<html><head><title>Registration</title>" +
            "</head><body><h1>Hello: %s</h1><a href=\"/get\">Go mail</a></body></html>";
    static Map<String, String> map = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login1");
        String pass = request.getParameter("pass1");
        String msg;
        map.put(login, pass);

        String temp = map.get(login);
        if(temp == null){
            msg = "User not found";
        } else if(temp.equals(pass)){
            msg = login;
        }  else {
            msg = "new user, create new profile";
        }

        response.getWriter().println(String.format(TEMPLATE, msg));

    }
}
