package com.joaogabriel.dotaApi.repository;

import com.joaogabriel.dotaApi.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<UserEntity, Integer> {
    @Query(value = "select * from tb_user where email like :email", nativeQuery = true)
    UserEntity getByEmail();
}
