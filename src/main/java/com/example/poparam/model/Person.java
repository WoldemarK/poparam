package com.example.poparam.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1905122041950251207L;
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 50,message = "Имя должно быть от 2 до 50 символов")
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "year_of_birth")
    @Min(value = 2000, message = "Год рождения должен быть больше чем 18 лет")
    private String yearOfBirth;

    public Person(String username, String password, String yearOfBirth) {
        this.username = username;
        this.password = password;
        this.yearOfBirth = yearOfBirth;
    }

}
