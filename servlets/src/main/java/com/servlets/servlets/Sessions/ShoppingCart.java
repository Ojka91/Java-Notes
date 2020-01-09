package com.servlets.servlets.Sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartServlet")
public class ShoppingCart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        //new http session
        HttpSession session = req.getSession();

        //get items
        List<String> items = (List<String>) session.getAttribute("items");

        //verify if list exist
        if(items == null){
            //init list
            items = new ArrayList<>();
            session.setAttribute("items", items);
        }

        //process new item
        String newItem = req.getParameter("item");
        //check new item
        if(newItem != null && !newItem.trim().equals("")){
            //add new item to list
            items.add(newItem);
        }

        //print list items
        PrintWriter out = resp.getWriter();
        out.print("Items list");
        out.print("<br>");
        //iteration items list
        for (String item:items) {
            out.print("<li>" + item + "</li>");
        }
        //link to back
        out.print("<br>");
        out.println("<a href='/'>Back");
        out.close();
    }
}
