package com.example.Intro.SumOf2Numbers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Sum", value = "/Sum")
public class SumLandingServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Print the form
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>JSP - Sum of 2 numbers</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<br/>\n" +
                "<form action=\"displaySum\" method=\"post\">\n" +
                "    <table style=\"with: 50%\">\n" +
                "        <tr>\n" +
                "            <td>Number 1</td>\n" +
                "            <td><input type=\"number\" name=\"num1\" id=\"num1\"/></td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>Number 2</td>\n" +
                "            <td><input type=\"number\" name=\"num2\" id=\"num2\"/></td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "    <input type=\"submit\" value=\"Submit\" />\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>");
    }
}
