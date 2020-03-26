package com.drbotro.coreservice.users;

import java.util.Date;

import com.drbotro.common.test.AbstractModelBeanTest;
import com.drbotro.coreserviceapi.users.UserResponse;

public class UserResponseTest extends AbstractModelBeanTest<UserResponse>{

    @Override
    public void initEntities(){
        Date date = new Date();

        this.entityA1 = UserResponse.builder().withId(01L).withFirstName("FirstName").withLastName("LastName")
                .withEmail("email").withCreatedAt(date).withCreatedBy("createdby").withUpdatedAt(date)
                .withUpdatedBy("updatedBy").build();
        this.entityA2 = UserResponse.builder().withId(01L).withFirstName("FirstName").withLastName("LastName")
                .withEmail("email").withCreatedAt(date).withCreatedBy("createdby").withUpdatedAt(date)
                .withUpdatedBy("updatedBy").build();
        this.entityB = UserResponse.builder().withId(02L).withFirstName("FirstNameB").withLastName("LastNameB")
                .withEmail("emailB").withCreatedAt(date).withCreatedBy("createdbyB").withUpdatedAt(date)
                .withUpdatedBy("updatedByB").build();

    }

}
