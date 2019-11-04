package com.ning.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/*
* ServletContext对象：
*       问题：不同用户时用相同的数据
*       解决：ServletContext对象
*       特点：服务器创建，用户共享
*       作用域：整个项目内
*       生命周期：服务器启动到服务器关闭
*       使用：
*           获取ServletContext对象
*           //第一种方式
                ServletContext sc = this.getServletContext();
            //第二种方式
                ServletContext sc2 = this.getServletConfig().getServletContext();
            //第三种方式
                ServletContext sc3 = request.getSession().getServletContext();
*           使用ServletContext对象完成数据共享
*               //数据存储
*               sc.setAttribute(String name,Object value);
*               //数据获取
*               sc.getAttribute(String name);返回的是object
*           注意：不同的用户可以给ServletContext对象进行数据的存取，数据不存在返回null
*
*           获取web.xml文件中的全局配置数据
*               sc.getInitParameter(String name);根据键的名字返回web.xml中配置的全局数据的值，返回的是String类型
*
*           配置方式：
*                <context-param>
                    <param-name>name</param-name>
                    <param-value>zhangsan</param-value>
                 </context-param>
            将静态数据和代码进行解耦

            获取web项目out下资源的绝对路径
             String path =sc.getRealPath("/doc/1.txt");
             获取的路径为项目根目录,path参数为项目根目录中的路径
            获取out下的资源的流对象
            InputStream is = sc.getResourceAsStream(String path);

            注意：此中方式只能获取项目根目录下的的资源流对象，class文件的流对象使用类加载器来获取，path参数为项目根目录中的路径
*/
public class MyServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取ServletContext对象的三种方式
        //第一种方式
        ServletContext sc = this.getServletContext();
        //第二种方式
        ServletContext sc2 = this.getServletConfig().getServletContext();
        //第三种方式
        ServletContext sc3 = request.getSession().getServletContext();
        System.out.println(sc == sc2);
        System.out.println(sc == sc3);
        //使用ServletContext对象完成数据共享
        //数据存储
        sc.setAttribute("str","我是ServletContext对象");
        //获取项目web.xml的全局配置数据
        String str = sc.getInitParameter("name2");
        System.out.println("全局配置参数："+str);

        //获取项目根目录下的资源的绝对路径
        String path =sc.getRealPath("/doc/1.txt");
        System.out.println(path);
        //获取项目根目录下资源的流对象
        InputStream is = sc.getResourceAsStream("/doc/1.txt");
    }
}
