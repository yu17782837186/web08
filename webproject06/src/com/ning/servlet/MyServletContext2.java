package com.ning.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServletContext2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建ServletContext对象
        ServletContext sc = this.getServletContext();
        //获取数据
        System.out.println("MyServletContext2"+sc.getAttribute("str"));
    }
}
