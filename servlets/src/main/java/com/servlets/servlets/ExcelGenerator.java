package com.servlets.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GenerateExcel")
public class ExcelGenerator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //indicate type answer to the browser
        response.setContentType("application/vnd.ms-excek");
        response.setHeader("Content-Disposition", "attachment; filename=excelExample.xls");
        //for a better use of excel poi.apache.org

        //dont save info on cache
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-control", "no-store");
        response.setDateHeader("Expires", -1);

        //deploy info to client
        PrintWriter out = response.getWriter();
        out.println("\tValues");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUMA(b2:b3)");
        out.close();

    }

}
