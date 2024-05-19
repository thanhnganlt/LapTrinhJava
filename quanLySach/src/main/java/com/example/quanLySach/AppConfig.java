package com.example.quanLySach;

import com.example.quanLySach.model.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    public List<Book> getBooks() {
        List<Book> listBooks = new ArrayList<>();

        Book book1 = new Book(1, "Clean Code"
                , "Robert"
                , 47.0
                , "Software"
                , "/images/hello.jpg");
        listBooks.add(book1);

        Book book2 = new Book(2, "Design Patterns"
                ,"Erich Gamma"
                , 55.0
                , "Software Design"
                , "/images/hello.jpg");
        listBooks.add(book2);

        return listBooks;
    }
}
