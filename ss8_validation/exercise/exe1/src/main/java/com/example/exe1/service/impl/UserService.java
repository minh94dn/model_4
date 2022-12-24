package com.example.exe1.service.impl;

import com.example.exe1.model.User;
import com.example.exe1.repository.IUserRepository;
import com.example.exe1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;


    @Override
    public void add(User user) {
        iUserRepository.save(user);
    }
}
