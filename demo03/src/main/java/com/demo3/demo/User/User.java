package com.demo3.demo.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="User")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

}
