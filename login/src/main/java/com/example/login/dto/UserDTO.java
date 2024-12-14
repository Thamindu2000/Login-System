package com.example.login.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserDTO {
    private int userId;
    private String username;
    private String name;
    private String address;
    private String email;
    private String role;
    private int contact;
    private String password;
}


