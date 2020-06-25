package com.codenation.service.impl;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.codenation.entities.User;

public class AuditorAwareImpl implements AuditorAware<String> {
	  
    @Override
    public Optional<String> getCurrentAuditor() {
    	
    	Optional<User> currentUser = Optional.ofNullable(SecurityContextHolder.getContext())
  			  .map(SecurityContext::getAuthentication)
  			  .filter(Authentication::isAuthenticated)
  			  .map(Authentication::getPrincipal)
  			  .map(User.class::cast);
    	
    	return Optional.ofNullable(currentUser.get().getUsername());
    }
}

