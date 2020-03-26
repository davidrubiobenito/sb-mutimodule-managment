package com.drbotro.webrs.controller.users;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drbotro.coreservice.users.UsersService;
import com.drbotro.coreserviceapi.users.UserResponse;
import com.drbotro.webapi.users.converters.UserResponseIntoUserWebResponseConverter;
import com.drbotro.webapi.users.response.UserWebResponse;
import com.drbotro.webapi.versions.v1.ResourceVersion;

@RestController
@RequestMapping(ResourceVersion.V1)
public class UsersController{

    @Autowired
    private UsersService usersService;
    private UserResponseIntoUserWebResponseConverter userResponseIntoUserWebResponseConverter = new UserResponseIntoUserWebResponseConverter();

    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<UserWebResponse>> getAllUsers(){

        List<UserWebResponse> userWebResponse = new ArrayList<>();

        Iterator<UserResponse> userResponseIterator = usersService.getAllUsers().iterator();
        while(userResponseIterator.hasNext()){
            UserResponse userResponse = userResponseIterator.next();
            userWebResponse.add(userResponseIntoUserWebResponseConverter.convert(userResponse));
        }

        return new ResponseEntity<>(userWebResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserWebResponse> getUsersById(@PathVariable(value = "id") Long userId){
        try{
            UserWebResponse userWebResponse = userResponseIntoUserWebResponseConverter
                    .convert(usersService.getUsersById(userId));
            return new ResponseEntity<>(userWebResponse, HttpStatus.OK);
        }catch(Exception ex){
            return ResponseEntity.ok().body(null);
        }
    }

}
