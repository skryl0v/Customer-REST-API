package com.krylov.springbootlesson.service;

import com.krylov.springbootlesson.model.ApiUserEntity;
import com.krylov.springbootlesson.repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApiUserDetailService implements UserDetailsService {
    @Autowired
    ApiUserRepository apiUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiUserEntity apiUserEntity = apiUserRepository.findByUsername(username);
        if (apiUserEntity == null) throw new UsernameNotFoundException(username);
        return new ApiUserDetails(apiUserEntity);
    }
}