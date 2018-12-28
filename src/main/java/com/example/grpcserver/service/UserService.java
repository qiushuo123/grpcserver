package com.example.grpcserver.service;

import com.example.grpcserver.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User getUserById(int userId);

    boolean addUser(User record);
}
