package com.servlets.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String user = request.getParameter("user");
        String pwd = request.getParameter("password");

        System.out.println("user = " + user);
        System.out.println("password = " + pwd);

        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("User Is " + user);
        out.print("<br/>");
        out.print("Password is " + pwd);
        out.print("</body>");
        out.print("</html>");
    }
}
