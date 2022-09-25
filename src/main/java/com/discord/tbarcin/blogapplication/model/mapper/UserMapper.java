package com.discord.tbarcin.blogapplication.model.mapper;

import com.discord.tbarcin.blogapplication.model.dto.UserDTO;
import com.discord.tbarcin.blogapplication.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDTO toDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setMail(user.getMail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUserStatus(user.getUserStatus());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User toEntity(UserDTO userDTO){
        User user = new User();

        user.setUserName(userDTO.getUserName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMail(userDTO.getMail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUserStatus(userDTO.getUserStatus());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
