package com.example.authorizationserver.users;

import org.springframework.data.repository.CrudRepository;

public interface TacoUserRepository extends CrudRepository<TacoUser, Long> {

    TacoUser findByUsername(String username);
}
