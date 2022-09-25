package com.discord.tbarcin.blogapplication.model.dto;


import com.discord.tbarcin.blogapplication.model.entity.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String mail;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,name = "user_status")
    private UserStatus userStatus;


}
