package com.example.Intro.SumOf2Numbers;

import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;

@WebServlet(name = "displaySum", value = "/displaySum")
public class SumDisplayServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Sum
        if(request.getParameter("num1") != null && request.getParameter("num2") != null){
            PrintWriter out = response.getWriter();
            out.println("Sum: "+(Long.parseLong(request.getParameter("num1"))+Long.parseLong(request.getParameter("num2"))));
        }

    }

}