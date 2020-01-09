package com.servlets.servlets.Sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    //Session is stored as cookie by default. Manually you can change it to use the url

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        HttpSession session = req.getSession(); //If session exist, it get it. If doesnt exist, automatically creates it
        String title = null;

        //Get visitCounter to the session
        Integer visitCounter = (Integer) session.getAttribute("visitCounter");
        //if its null -> first time we acces to the app
        if(visitCounter == null){
            visitCounter = 1;
            title = "Welcome first time";
        }else{
            visitCounter++;
            title = "Welcome again";
        }

        //add new calue on session
        session.setAttribute("visitCounter", visitCounter);

        //send response to client
        PrintWriter out = resp.getWriter();
        out.print(title);
        out.print("<br>");
        out.print("Number times accesses " + visitCounter);
        out.print("<br>");
        out.print("ID session " + session.getId());
        out.close();

    }
}
