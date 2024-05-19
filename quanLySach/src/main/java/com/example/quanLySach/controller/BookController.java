package com.example.quanLySach.controller;

import com.example.quanLySach.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class BookController {
    @Autowired
    private List<Book> listBook;
    private AtomicInteger currentId = new AtomicInteger(4);
    @GetMapping("/")
    public String showAllBooks(Model model) {
        model.addAttribute("listBook", listBook);
        model.addAttribute("title", "Danh sách cuốn sách ");
        return "book/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }
    @PostMapping("/add")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }
        book.setId(currentId.getAndIncrement());
        book.setImageUrl("/images/hello.jpg");
        listBook.add(book);
        return "redirect:/";
    }
    @PostMapping("/book/edit/{id}")
    public String editBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/edit";
        }
        Book existingBook = listBook.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        if (existingBook != null) {
            existingBook.setTitle(book.getTitle());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setPrice(book.getPrice());
            existingBook.setCategory(book.getCategory());
            existingBook.setImageUrl(book.getImageUrl());
        }
        return "redirect:/";
    }

    @GetMapping("/book/edit/{id}")
    public String editBookForm(@PathVariable("id") int id, Model model) {
        Book book = listBook.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
        if (book != null) {
            model.addAttribute("book", book);
            return "book/edit";
        }
        return "redirect:/";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        listBook.removeIf(b -> b.getId() == id);
        return "redirect:/";
    }
}
