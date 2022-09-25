package com.discord.tbarcin.blogapplication.services;

import com.discord.tbarcin.blogapplication.model.dto.UserDTO;
import com.discord.tbarcin.blogapplication.model.entity.User;
import com.discord.tbarcin.blogapplication.model.mapper.UserMapper;
import com.discord.tbarcin.blogapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> allUser = userRepository.findAll();
        return allUser;
    }

    public User createUser(UserDTO userDTO){

        User user = UserMapper.toEntity(userDTO);
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    public User getUserById(Long id){
        Optional<User> byId = userRepository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("Kullanici bulunamadi."));
    }

    public void deleteByID(Long id){
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, UserDTO userDTO){
        Optional<User> byId = userRepository.findById(id);
        if(!byId.isPresent()){
            return null;
        }
        User updatedUser = byId.get();
        // Eğer ki içi boşsa true döner. İçi doluysa false döner
        if(!StringUtils.isEmpty(userDTO.getUserName())){
            updatedUser.setUserName(userDTO.getUserName());
        }
        if(!StringUtils.isEmpty(userDTO.getFirstName())){
            updatedUser.setFirstName(userDTO.getFirstName());
        }
        if(!StringUtils.isEmpty(userDTO.getLastName())){
            updatedUser.setLastName(userDTO.getLastName());
        }
        if(!StringUtils.isEmpty(userDTO.getMail())){
            updatedUser.setMail(userDTO.getMail());
        }
        if(!StringUtils.isEmpty(userDTO.getPassword())){
            updatedUser.setPassword(userDTO.getPassword());
        }
        if(!StringUtils.isEmpty(userDTO.getPhoneNumber())){
            updatedUser.setPhoneNumber(userDTO.getPhoneNumber());
        }
        if(!StringUtils.isEmpty(userDTO.getUserStatus())){
            updatedUser.setUserStatus(userDTO.getUserStatus());
        }
        return userRepository.save(updatedUser);
    }
}
