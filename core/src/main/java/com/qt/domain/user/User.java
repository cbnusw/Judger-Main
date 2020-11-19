package com.qt.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    //@NotNull
    //private String universityCode;

    @NotNull
    @Column(unique = true)
    private String userId;

    //@NotNull
    //private String name;

    //@NotNull
    //@Email
    //private String email;

    //@NotNull
    //private String phoneNumber;

    public User(@NotNull String userId) {
        this.userId = userId;
    }
/*
    public User(@NotNull String userId, @NotNull String name, @NotNull @Email String email, @NotNull String phoneNumber) {
        //this.universityCode = universityCode;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

 */

}
