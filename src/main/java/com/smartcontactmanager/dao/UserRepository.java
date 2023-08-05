package com.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontactmanager.entities.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
    
    @Query("select u from Users u where u.email = :email")
    
    public Users getUserByUserName(@Param("email") String email);

}
