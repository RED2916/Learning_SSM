package com.tydic.service;

import com.tydic.dao.BooksMapper;
import com.tydic.pojo.Books;
import lombok.Setter;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class BooksServiceImpl implements BooksService {
    @Setter
    private BooksMapper booksMapper;
    @Setter
    private SqlSessionTemplate sqlSessionTemplate;
    @Override
    public List<Books> getAllBooks() {
        return booksMapper.getAllBooks();
    }

    @Override
    public Books getBooksById(int booksID) {
        return booksMapper.getBooksById(booksID);
    }

    @Override
    public int addBooks(Books books) {
        return booksMapper.addBooks(books);
    }

    @Override
    public int updateBooks(Books books) {
        return booksMapper.updateBooks(books);
    }

    @Override
    public int deleteBooksById(int bookID) {
        return booksMapper.deleteBooksById(bookID);
    }

    @Override
    public List<Books> getBooksByName(String bookName) {
        return booksMapper.getBooksByName(bookName);
    }

    @Override
    public List<Books> getBooksByPage(int begin, int pageSize) {
        RowBounds rowBounds = new RowBounds(begin,pageSize);
        List<Books> booksList = sqlSessionTemplate.selectList("com.tydic.dao.BooksMapper.getAllBooks", null, rowBounds);
        return booksList;
    }

    @Override
    public int getBooksAmout() {
        return booksMapper.getBooksAmount();
    }
}
