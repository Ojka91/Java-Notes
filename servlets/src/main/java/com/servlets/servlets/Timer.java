package com.servlets.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Timer")
public class Timer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("refresh", "1");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("'Updated time' HH:mm:ss");
        String timerFormatted = format.format(date);
        PrintWriter out = response.getWriter();
        out.print(timerFormatted);
        out.close();

    }
}
