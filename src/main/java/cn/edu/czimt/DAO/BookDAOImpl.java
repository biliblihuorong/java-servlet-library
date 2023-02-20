package cn.edu.czimt.DAO;

import cn.edu.czimt.pojo.Book;
import cn.edu.czimt.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Override
    public Integer addBook(Book book) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BookDAO mapper = sqlSession.getMapper(BookDAO.class);
        Integer i =null;
        try {
            i = mapper.addBook(book);
            sqlSession.commit();

        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }
        return i;
    }

    @Override
    public Integer delBook(int bookID) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int i=0;
        try {
            BookDAO mapper = sqlSession.getMapper(BookDAO.class);
            i= mapper.delBook(bookID);
            sqlSession.commit();

        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }
        return i;
    }

    @Override
    public Integer upDataBook(Integer bookID, Book book) {SqlSession sqlSession = MybatisUtils.getSqlSession();
        int i = 0;
        try {
            BookDAO mapper = sqlSession.getMapper(BookDAO.class);
            i = mapper.upDataBook(bookID, book);
            sqlSession.commit();


        }catch (Exception e){
            sqlSession.rollback();
            System.out.println(e);
        }
        return i;
    }

    @Override
    public List<Book> selectBook() {
        BookDAO mapper = MybatisUtils.getMapper(BookDAO.class);
        List<Book> books = mapper.selectBook();
        return books;
    }



}
