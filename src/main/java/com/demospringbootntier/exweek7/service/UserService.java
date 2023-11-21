package com.demospringbootntier.exweek7.service;

import com.demospringbootntier.exweek7.domain.User;
import com.demospringbootntier.exweek7.model.UserDTO;
import com.demospringbootntier.exweek7.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        // Chuyển đổi danh sách người dùng sang danh sách DTO
        return userRepository.getAllUsers().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(Long id) {
        User user = userRepository.getUserById(id);
        if (user != null) {
            return convertToDTO(user);
        }
        return null;
    }

    public void addUser(UserDTO userDTO) {
        // Chuyển đổi DTO sang đối tượng domain và lưu vào repository
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        userRepository.addUser(user);
    }

    //cập nhật và xóa người dùng

    private UserDTO convertToDTO(User user) {
        // Chuyển đối tượng domain sang DTO
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}