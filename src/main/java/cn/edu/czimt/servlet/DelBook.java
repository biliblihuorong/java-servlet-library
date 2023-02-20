package cn.edu.czimt.servlet;

import cn.edu.czimt.DAO.BookDAOImpl;
import cn.edu.czimt.pojo.Book;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "DelBook", value = "/delBook")
public class DelBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String json =reader.readLine();
        List<Book> books = JSONArray.parseArray(json, Book.class);
        BookDAOImpl bookDAO = new BookDAOImpl();
        Book book = books.get(0);
        Integer integer = bookDAO.delBook(book.getBookID());
        PrintWriter writer = response.getWriter();
        response.setContentType("text/json;charset=UTF-8");
//        writer.write(integer);
        String jsonString1 = JSON.toJSONString(book);
//        response.getWriter().write(jsonString);
        response.getWriter().write(jsonString1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
