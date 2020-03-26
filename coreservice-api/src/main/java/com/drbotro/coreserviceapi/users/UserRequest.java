package com.drbotro.coreserviceapi.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.drbotro.common.domain.AbstractModelBean;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("serial")
public class UserRequest extends AbstractModelBean{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String email;
    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private Date createdAt;
    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;
    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private Date updatedAt;
    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;

    private UserRequest(Builder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.createdAt = builder.createdAt;
        this.createdBy = builder.createdBy;
        this.updatedAt = builder.updatedAt;
        this.updatedBy = builder.updatedBy;
    }

    public long getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public String getCreatedBy(){
        return createdBy;
    }

    public Date getUpdatedAt(){
        return updatedAt;
    }

    public String getUpdatedBy(){
        return updatedBy;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder().append(getId()).append(getFirstName()).append(getLastName()).append(getEmail())
                .append(getCreatedAt()).append(getCreatedBy()).append(getUpdatedAt()).append(getUpdatedBy()).hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof UserRequest){
            final UserRequest other = (UserRequest) obj;
            return new EqualsBuilder().append(getId(), other.getId()).append(getFirstName(), other.getFirstName())
                    .append(getLastName(), other.getLastName()).append(getEmail(), other.getEmail())
                    .append(getCreatedAt(), other.getCreatedAt()).append(getCreatedBy(), other.getCreatedBy())
                    .append(getUpdatedAt(), other.getUpdatedAt()).append(getUpdatedBy(), other.getUpdatedBy())
                    .isEquals();
        }
        return false;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder{
        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private Date createdAt;
        private String createdBy;
        private Date updatedAt;
        private String updatedBy;

        private Builder(){
        }

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Builder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Builder withCreatedAt(Date createdAt){
            this.createdAt = createdAt;
            return this;
        }

        public Builder withCreatedBy(String createdBy){
            this.createdBy = createdBy;
            return this;
        }

        public Builder withUpdatedAt(Date updatedAt){
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder withUpdatedBy(String updatedBy){
            this.updatedBy = updatedBy;
            return this;
        }

        public UserRequest build(){
            return new UserRequest(this);
        }
    }

}
