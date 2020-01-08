package com.servlets.servlets.Cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //user visit first time
        boolean newUser = true;
        int counter = 0;

        //get array cookies
        Cookie[] cookies = request.getCookies();

        //search existing cookie, check if its recurrent visitor
        if(cookies != null){
            for (Cookie c: cookies) {
                if(c.getName().equals("recurrentVisitor") && c.getValue().equals("yes")){
                    //if user exist, it's recurrent
                    newUser = false;
                }
                if(c.getName().equals("visitorCounter")){
                    counter = Integer.parseInt(c.getValue()); //convert string to int
                }

            }
        }

        //increase counter
        counter++;

        //add new cookie
        Cookie c = new Cookie("visitorCounter", Integer.toString(counter));
        //save cookie for only one hour (in seconds)
        c.setMaxAge(3600);
        response.addCookie(c);

        String msg = null;
        if(newUser){
            Cookie newCookie = new Cookie("recurrentVisitor", "yes");
            response.addCookie(newCookie);
            msg = "Thanks for visiting for FIRST time";
        }else{
            msg = "Thanks for visiting AGAIN our site";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(msg);
        out.print("Counter visits: " + counter);
        out.close();
    }
}
