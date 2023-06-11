package com.example.poparam.repository;

import com.example.poparam.model.Person;
import com.example.poparam.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findBaseUserByUsername(String username);
    @Query("SELECT bu.role FROM Person bu WHERE bu.username = :username")
    Role getBaseUserRoleByUsername(String username);
}
