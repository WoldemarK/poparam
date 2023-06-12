package ru.opali.repository;

import ru.opali.model.Person;
import ru.opali.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findBaseUserByUsername(String username);

    @Query("SELECT bu.role FROM Person bu WHERE bu.username = :username")
    Role getBaseUserRoleByUsername(String username);

    Role findByUsername(String username);
}
