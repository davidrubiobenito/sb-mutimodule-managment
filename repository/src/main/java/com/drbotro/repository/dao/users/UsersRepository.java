package com.drbotro.repository.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drbotro.coreserviceapi.users.UserResponse;

@Repository
public interface UsersRepository extends JpaRepository<UserResponse, Long>{
}
