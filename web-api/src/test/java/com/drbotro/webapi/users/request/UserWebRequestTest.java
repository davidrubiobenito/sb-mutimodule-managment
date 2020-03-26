package com.drbotro.webapi.users.request;

import java.util.Date;

import com.drbotro.common.test.AbstractModelBeanTest;

public class UserWebRequestTest extends AbstractModelBeanTest<UserWebRequest>{

    @Override
    public void initEntities(){
        final Date date = new Date();
        this.entityA1 = UserWebRequest.builder().withId(01L).withFirstName("FirstName").withLastName("LastName")
                .withEmail("email").withCreatedAt(date).withCreatedBy("createdby").withUpdatedAt(date)
                .withUpdatedBy("updatedBy").build();
        this.entityA2 = UserWebRequest.builder().withId(01L).withFirstName("FirstName").withLastName("LastName")
                .withEmail("email").withCreatedAt(date).withCreatedBy("createdby").withUpdatedAt(date)
                .withUpdatedBy("updatedBy").build();
        this.entityB = UserWebRequest.builder().withId(02L).withFirstName("FirstNameB").withLastName("LastNameB")
                .withEmail("emailB").withCreatedAt(date).withCreatedBy("createdbyB").withUpdatedAt(date)
                .withUpdatedBy("updatedByB").build();
    }

}
