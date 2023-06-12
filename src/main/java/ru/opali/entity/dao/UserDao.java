package ru.opali.entity.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserDao {

    @Id
    @GeneratedValue
    private Long id;



}
