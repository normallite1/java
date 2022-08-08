package com.example.questionnaire;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    static int more20  = 0;
    static int less20 = 0;
    static int yes = 0;
    static int no = 0;

    static final  String TEMPLATE ="<html>"+
            "<head><title>Java</title></head>"+
            "<body><h1>%s</h1></body></html>";

    static final int[] result = new int[4];

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String q1 = request.getParameter("question1");
        final String q2 = request.getParameter("question2");
        if("More 20".equals(q1)){
            more20++;
        } else {
            less20++;
        }

        if("Yes".equals(q2)){
            yes++;
        } else {
            no++;
        }

        String res = "<p>Question 1: More than 20 = " + more20 +", less than 20 = " + less20+"</p>";
        res += "<p>Question 2: Yes = " + yes +", No = " + no+"</p>";

        response.getWriter().println(String.format(TEMPLATE, res));
    }

    public void destroy() {
    }
}