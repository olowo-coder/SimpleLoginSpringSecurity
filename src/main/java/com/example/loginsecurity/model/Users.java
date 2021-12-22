package com.example.loginsecurity.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Users {

    @Id
    private Long userId;
    private String username;
    private String password;
    private String role;

}
