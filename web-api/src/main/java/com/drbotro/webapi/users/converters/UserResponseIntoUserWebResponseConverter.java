package com.drbotro.webapi.users.converters;

import org.springframework.stereotype.Component;

import com.drbotro.common.converter.Converter;
import com.drbotro.coreserviceapi.users.UserResponse;
import com.drbotro.webapi.users.response.UserWebResponse;

@Component
public class UserResponseIntoUserWebResponseConverter implements Converter<UserResponse, UserWebResponse>{

    @Override
    public UserWebResponse convert(UserResponse userResponse){

        if(userResponse == null){
            return null;
        }

        return UserWebResponse.builder().withId(userResponse.getId()).withFirstName(userResponse.getFirstName())
                .withLastName(userResponse.getLastName()).withEmail(userResponse.getEmail())
                .withCreatedAt(userResponse.getCreatedAt()).withCreatedBy(userResponse.getCreatedBy())
                .withUpdatedAt(userResponse.getUpdatedAt()).withUpdatedBy(userResponse.getUpdatedBy()).build();
    }

}
