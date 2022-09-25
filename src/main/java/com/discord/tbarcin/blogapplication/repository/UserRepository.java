package com.discord.tbarcin.blogapplication.repository;


import com.discord.tbarcin.blogapplication.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
