package com.bookstore.services;

import com.bookstore.entity.Category;
import com.bookstore.entity.User;
import com.bookstore.repository.ICategoryRepository;
import com.bookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private IUserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }
}