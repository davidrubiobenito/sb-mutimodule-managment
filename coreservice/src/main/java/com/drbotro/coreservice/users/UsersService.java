package com.drbotro.coreservice.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drbotro.coreserviceapi.users.UserResponse;
import com.drbotro.repository.dao.users.UsersRepository;

@Service
public class UsersService{

    @Autowired
    private UsersRepository usersRepository;

    public List<UserResponse> getAllUsers(){
        List<UserResponse> users = new ArrayList<>();
        usersRepository.findAll().forEach(users::add);
        return users;
    }

    public UserResponse getUsersById(Long id){
        return usersRepository.findById(id).get();
    }

}
