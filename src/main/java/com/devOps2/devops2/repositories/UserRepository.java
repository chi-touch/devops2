package com.devOps2.devops2.repositories;

import com.devOps2.devops2.models.DevUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<DevUser, Long> {
     DevUser findDevUserByUserNameIgnoreCase(String userName);
}
