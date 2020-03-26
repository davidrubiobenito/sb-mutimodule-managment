package com.drbotro.webapi.users.converters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Test;

import com.drbotro.coreserviceapi.users.UserResponse;
import com.drbotro.webapi.users.response.UserWebResponse;

public class UserResponseIntoUserWebResponseConverterTest{

    final Date date = new Date();

    UserResponseIntoUserWebResponseConverter converter = new UserResponseIntoUserWebResponseConverter();

    @Test
    public void shouldReturnNull_IfNullPassed(){
        assertNull(converter.convert(null));
    }

    @Test
    public void givenUserResponseIntoUserWebResponse(){

        final UserResponse userResponse = UserResponse.builder().withId(01L).withFirstName("FirstName")
                .withLastName("LastName").withEmail("email").withCreatedAt(date).withCreatedBy("createdby")
                .withUpdatedAt(date).withUpdatedBy("updatedBy").build();
        final UserWebResponse userWebResponseExpected = getUserWebRequest();

        final UserWebResponse userWebResponse = converter.convert(userResponse);

        assertThat(userWebResponse, is(equalTo(userWebResponseExpected)));

    }

    private UserWebResponse getUserWebRequest(){
        return UserWebResponse.builder().withId(01L).withFirstName("FirstName").withLastName("LastName")
                .withEmail("email").withCreatedAt(date).withCreatedBy("createdby").withUpdatedAt(date)
                .withUpdatedBy("updatedBy").build();
    }

}
