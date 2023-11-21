package com.demospringbootntier.exweek7.model;

public class UserDTO {
    private Long Id;
    private String username;
    private String email;

    // constructors, getters, setters

    public UserDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public UserDTO() {

    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
    }

    public Long getId() {
        return Id;
    }
}