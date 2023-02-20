package cn.edu.czimt.DAO;

import cn.edu.czimt.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDAO {
    public Integer addBook(Book book);
    public Integer delBook(int bookID);
    public Integer upDataBook(@Param("bookID") Integer bookID,@Param("book") Book book);
    public List<Book> selectBook();//@Param("page")int page,@Param("row")int row
}
