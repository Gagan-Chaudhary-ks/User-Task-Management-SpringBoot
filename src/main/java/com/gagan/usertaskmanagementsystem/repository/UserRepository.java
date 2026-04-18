package com.gagan.usertaskmanagementsystem.repository;

import com.gagan.usertaskmanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}