package com.drbotro.webapi.users.converters;

import org.springframework.stereotype.Component;

import com.drbotro.common.converter.Converter;
import com.drbotro.coreserviceapi.users.UserRequest;
import com.drbotro.webapi.users.request.UserWebRequest;

@Component
public class UserWebRequestIntoUserRequestConverter implements Converter<UserWebRequest, UserRequest>{

    @Override
    public UserRequest convert(UserWebRequest userWebRequest){

        if(userWebRequest == null){
            return null;
        }

        return UserRequest.builder().withId(userWebRequest.getId()).withFirstName(userWebRequest.getFirstName())
                .withLastName(userWebRequest.getLastName()).withEmail(userWebRequest.getEmail())
                .withCreatedAt(userWebRequest.getCreatedAt()).withCreatedBy(userWebRequest.getCreatedBy())
                .withUpdatedAt(userWebRequest.getUpdatedAt()).withUpdatedBy(userWebRequest.getUpdatedBy()).build();
    }

}
