package com.krylov.springbootlesson.repository;

import com.krylov.springbootlesson.model.ApiUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiUserRepository extends CrudRepository<ApiUserEntity, Long> {
    ApiUserEntity findByUsername(String username);
}