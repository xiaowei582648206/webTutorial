package com.hnu.cloudmining.servletApp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2019/3/11.
 * 以后凡是出现中文的java文件，一律采用utf-8编码
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head><title>使用javaServlet编写hellowrold程序</title></head>");
        writer.println("<body>");
        writer.println("<h1><font color=\"red\">hello world , this is my first servlet demo ! </font></h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }
}
