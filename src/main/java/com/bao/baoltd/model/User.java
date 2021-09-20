package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "APP_USER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME", nullable = false, length = 25)
    private String name;

    @Column(name = "SURNAME", nullable = false, length = 25)
    private String surname;

    @Column(name = "USERNAME", nullable = false, length = 50)
    private String fullName;

    @Email
    @Column(name = "EMAIL", nullable = false)
    private String email;
   

}
