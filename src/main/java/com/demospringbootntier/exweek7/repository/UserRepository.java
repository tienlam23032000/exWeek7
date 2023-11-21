package com.demospringbootntier.exweek7.repository;

import com.demospringbootntier.exweek7.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        // Tìm kiếm người dùng theo ID
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void addUser(User user) {
        // Thêm người dùng mới
        users.add(user);
    }

}