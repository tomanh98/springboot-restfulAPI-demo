package com.example.restfulapi.repositories;

import com.example.restfulapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    //UserEntity: Kieu cua thuc the, Long: kieu du lieu cua khoa chinh
    List<UserEntity> findByName(String name);
}
