package com.bao.baoltd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "USER_NAME", nullable = false, length = 25)
    private String name;

    @Column(name = "USER_LAST_NAME", nullable = false, length = 25)
    private String lastName;

    @Column(name = "FULL_NAME", nullable = false, length = 50)
    private String fullName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    private String phoneNumber;

}
