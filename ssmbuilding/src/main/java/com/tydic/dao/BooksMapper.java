package com.tydic.dao;

import com.tydic.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.awt.print.Book;
import java.util.List;

public interface BooksMapper {
    public List<Books> getAllBooks();
    public Books getBooksById(int booksID);
    public int addBooks(Books books);
    public int updateBooks(Books books);
    public int deleteBooksById(int bookID);
    public List<Books> getBooksByName(@Param("bookName") String bookName);
    public int getBooksAmount();
}
