package com.hnu.cloudmining.servletApp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2019/3/12.
 * 以后凡是出现中文的java文件，一律采用utf-8编码
 *only if the chainese character shows in the java file, the encoding of file must be "utf-8"
 */
public class InputServlet extends HttpServlet {
    public InputServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");  // request 和 response 的字符格式一律设置成utf-8
        String info = req.getParameter("info");
        resp.setCharacterEncoding("utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head><title>使用servlet接收前台页面提交的表单参数，并显示</title></head>");
        writer.println("<body>");
        writer.println("<h1><font color=\"red\">hello world , this is my second servlet demo ! </font></h1>");
        writer.println("<h2><font color=\"blue\">" + info + "</font></h1>");
        writer.println("</body>");
        writer.println("</html>");
        writer.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
