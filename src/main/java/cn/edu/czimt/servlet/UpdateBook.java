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
import java.util.List;

@WebServlet(name = "UpdateBook", value = "/updateBook")
public class UpdateBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String json =reader.readLine();
        List<Book> books = JSONArray.parseArray(json, Book.class);
        Book book = books.get(0);
        BookDAOImpl bookDAO = new BookDAOImpl();
        Integer integer = bookDAO.upDataBook(book.getBookID(), book);

        response.setContentType("text/json;charset=UTF-8");
        String jsonString1 = JSON.toJSONString(book);
//        response.getWriter().write(jsonString);
        response.getWriter().write(jsonString1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
