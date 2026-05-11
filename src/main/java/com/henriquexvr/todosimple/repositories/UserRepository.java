package com.henriquexvr.todosimple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquexvr.todosimple.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
