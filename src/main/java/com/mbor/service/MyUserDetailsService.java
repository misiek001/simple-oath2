package com.mbor.service;

import com.mbor.domain.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface MyUserDetailsService extends UserDetailsService, IService<User> {

}
