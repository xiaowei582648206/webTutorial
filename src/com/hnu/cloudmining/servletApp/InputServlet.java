package com.hnu.cloudmining.servletApp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xiao on 2019/3/11.
 */
public class InputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("======== do get ============");
        String info = req.getParameter("info");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head><title> π”√javaServlet±‡–¥hellowrold≥Ã–Ú</title></head>");
        writer.println("<body>");
        writer.println("<h1><font color=\"red\">hello world , this is my second servlet demo ! </font></h1>");
        writer.println("<h2><font color=\"blue\">" + info + "</font></h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("======== do post ============");
       this.doGet(req,resp);
    }
}
