package com.discord.tbarcin.blogapplication.controller;

import com.discord.tbarcin.blogapplication.model.dto.UserDTO;
import com.discord.tbarcin.blogapplication.model.entity.User;
import com.discord.tbarcin.blogapplication.repository.UserRepository;
import com.discord.tbarcin.blogapplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
    GET-POST-PUT-DELETE
    */

    @GetMapping("/all")
    public List<User> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity createNewUser(@RequestBody UserDTO userDTO){
        User respUser = userService.createUser(userDTO);
        if(respUser==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kullanici basarili sekilde olusturulamadi");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respUser);
    }


    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id){
        User userById;
        try{
            userById = userService.getUserById(id);
        }catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Kullanici bulunamadi");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userById);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id){
        try {
            userService.deleteByID(id);
        } catch (RuntimeException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Silinecek Kullanici bulunamadi.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Kullanici basariyla silindi.");
    }

    /*
    *@GetMapping("/{user-id}")
    *public User getUserById(@PathVariable("user-id") long id) {
    *    return userService.getUserById(id);
    *}
    */

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Long id,@RequestBody UserDTO userDTO){
        User updateUser = userService.updateUser(id, userDTO);
        if(updateUser== null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Kullanici guncellenemedi. Boyle bir kullanici yok.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(updateUser);
    }

}
