package com.codenation.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.codenation.entities.User;

@Repository
public interface UserRepository extends BaseRepository<User, Long>{

	UserDetails findByUsername(String username);

}
