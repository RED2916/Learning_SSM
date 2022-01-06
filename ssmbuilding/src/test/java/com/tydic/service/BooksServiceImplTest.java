package com.tydic.service;

import com.tydic.pojo.Books;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BooksServiceImplTest extends TestCase {

    public void testGetAllBooks() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksServiceImpl booksService = context.getBean("booksServiceImpl", BooksServiceImpl.class);
        List<Books> allBooks = booksService.getAllBooks();
        for (Books allBook : allBooks) {
            System.out.println(allBook);
        }
    }

    public void testAddBooks(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksServiceImpl booksService = context.getBean("booksServiceImpl", BooksServiceImpl.class);
        int result = booksService.addBooks(new Books(4,"Spring",2,"从变强到变秃"));
        System.out.println(result);
    }

    public void  testDeleteBooks(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksServiceImpl booksService = context.getBean("booksServiceImpl", BooksServiceImpl.class);
        int result = booksService.deleteBooksById(4);
        System.out.println(result);
    }

    public void  testGetBooksByName(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksServiceImpl booksService = context.getBean("booksServiceImpl", BooksServiceImpl.class);
        List<Books> spring = booksService.getBooksByName("Spring");
        System.out.println(spring);
    }
}