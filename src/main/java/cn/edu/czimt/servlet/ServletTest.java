package cn.edu.czimt.servlet;

import cn.edu.czimt.pojo.Book;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ServletTest", value = "/servletTest")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String json = reader.readLine();
        System.out.println(json);
        Book book = JSON.parseObject(json, Book.class);
        System.out.println("=====");
        System.out.println(book);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
