package com.gupao.springbootjsp.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: spring-boot-jsp
 * @description:
 * @author:Daniel.zhao
 * @create:2018-05-09 17:09
 **/
public class TestServlet extends HttpServlet{
    //重写get方法


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置返回类型为json
        resp.setContentType("application/json");
        //设置返回字符集
        resp.setCharacterEncoding("utf-8");
        //输出对象
        PrintWriter writer=resp.getWriter();
        //输出error 对象
        writer.write("执行doget方法成功" );
        writer.close();
    }
}
