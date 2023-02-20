package cn.edu.czimt.DAO;

import cn.edu.czimt.pojo.Book;
import cn.edu.czimt.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {

    @Test
    public void addBook() {
        Book book = new Book(1,"三体3", "刘慈欣", 45, "2022-5-11");
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookDAO mapper = sqlSession.getMapper(BookDAO.class);
        Integer book1 =null;
        try {
            book1 = mapper.addBook(book);
            sqlSession.commit();
            System.out.println(book);
        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }


    }

    @Test
    public void selectBook(){
        BookDAO mapper = MybatisUtils.getMapper(BookDAO.class);

//        PageHelper.startPage(1,1);
//        List<Book> books = mapper.selectBook(1,1);
//        for (Book book : books) {
//            System.out.println(book);
//        }
    }

    @Test
    public void delBook() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int i=0;
        try {
            BookDAO mapper = sqlSession.getMapper(BookDAO.class);
            i= mapper.delBook(1);
            sqlSession.commit();

        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }
    }

    @Test
    public void upDataBook() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            BookDAO mapper = sqlSession.getMapper(BookDAO.class);
            int i = mapper.upDataBook(2, new Book(2, "三体2", "刘慈欣", 45, "2022-5-11"));
            sqlSession.commit();


        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }
    }
}