package com.drbotro.webapi.users.converters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import com.drbotro.coreserviceapi.users.UserRequest;
import com.drbotro.webapi.users.request.UserWebRequest;

public class UserWebRequestIntoUserRequestConverterTest{

    final Date date = new Date();

    UserWebRequestIntoUserRequestConverter converter = new UserWebRequestIntoUserRequestConverter();

    @Test
    public void shouldReturnNull_IfNullPassed(){
        assertNull(converter.convert(null));
    }

    @Test
    public void givenUserWebRequestIntoUserRequest(){

        final UserWebRequest userWebRequest = UserWebRequest.builder().withId(01L).withFirstName("FirstName")
                .withLastName("LastName").withEmail("email").withCreatedAt(date).withCreatedBy("createdby")
                .withUpdatedAt(date).withUpdatedBy("updatedBy").build();
        final UserRequest userRequestExpected = getUserRequest();

        final UserRequest userRequest = converter.convert(userWebRequest);

        assertThat(userRequest, is(equalTo(userRequestExpected)));

    }

    private UserRequest getUserRequest(){
        return UserRequest.builder().withId(01L).withFirstName("FirstName").withLastName("LastName").withEmail("email")
                .withCreatedAt(date).withCreatedBy("createdby").withUpdatedAt(date).withUpdatedBy("updatedBy").build();
    }

}
