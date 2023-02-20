package cn.edu.czimt.servlet;

import cn.edu.czimt.DAO.BookDAOImpl;
import cn.edu.czimt.pojo.Book;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "selectBook", value = "/selectBook")
public class selectBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer page = Integer.parseInt(request.getParameter("page"));
        Integer row = Integer.parseInt(request.getParameter("row"));
            BookDAOImpl bookDAO = new BookDAOImpl();
            List<Book> books = bookDAO.selectBook();
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        String jsonBook = JSON.toJSONString(books);
        System.out.println(jsonBook);
        response.getWriter().write(jsonBook);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
