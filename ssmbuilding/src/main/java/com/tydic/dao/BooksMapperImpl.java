package com.tydic.dao;

import com.tydic.pojo.Books;
import lombok.Setter;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class BooksMapperImpl implements BooksMapper {
    @Setter
    private SqlSessionTemplate sqlSession;


    @Override
    public List<Books> getAllBooks() {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.getAllBooks();
    }

    @Override
    public Books getBooksById(int booksID) {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.getBooksById(booksID);
    }

    @Override
    public int addBooks(Books books) {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.addBooks(books);
    }

    @Override
    public int updateBooks(Books books) {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.updateBooks(books);
    }

    @Override
    public int deleteBooksById(int bookID) {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.deleteBooksById(bookID);
    }

    @Override
    public List<Books> getBooksByName(String bookName) {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.getBooksByName(bookName);
    }

    @Override
    public int getBooksAmount() {
        BooksMapper mapper = sqlSession.getMapper(BooksMapper.class);
        return mapper.getBooksAmount();
    }
}
