package com.demospringbootntier.exweek7;

import com.demospringbootntier.exweek7.model.UserDTO;
import com.demospringbootntier.exweek7.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class ExWeek7Application {
    public static void main(String[] args) {
        // Khởi chạy ứng dụng Spring Boot và nhận về ApplicationContext
        ApplicationContext context = SpringApplication.run(ExWeek7Application.class, args);

        // Lấy bean từ ApplicationContext (ví dụ: UserService)
        UserService userService = context.getBean(UserService.class);

        //thêm người dùng
        UserDTO user1 = new UserDTO();
        user1.setUsername("Lam");
        user1.setEmail("Lam@gmail.com");
        userService.addUser(user1);

        UserDTO user2 = new UserDTO();
        user2.setUsername("Hang");
        user2.setEmail("Hang@gmail.com");
        userService.addUser(user2);

        // In ra danh sách người dùng sau khi thêm
        System.out.println("List of users:");
        userService.getAllUsers().forEach(user -> {
            System.out.println("ID: " + user.getId() +
                    ", Username: " + user.getUsername() +
                    ", Email: " + user.getEmail());
        });

        // Đóng ứng dụng sau khi hoàn thành các tác vụ
        ((ConfigurableApplicationContext) context).close();
    }
}