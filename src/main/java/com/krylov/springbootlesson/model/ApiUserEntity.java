package com.krylov.springbootlesson.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "api_users", indexes = {@Index(columnList = "username_")})
public class ApiUserEntity {
    @Id
    @GeneratedValue
    @Column(name = "id_")
    private long id;
    @Column(name = "username_", length = 300)
    private String username;
    @Column(name = "password_", length = 300)
    private String password;
    @Column(name = "is_enabled_")
    private boolean isEnabled;
}
