package com.qt.domain.user.dto;

import com.qt.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
public class UserInfo {

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

    @Builder
    public UserInfo( @NotNull String userId) {
        //this.universityCode = universityCode;
        this.userId = userId;
       // this.name = name;

        //this.phoneNumber = phoneNumber;
    }
/*
    public User toEntity() {
        return new User(userId, name, email, phoneNumber);
    }


 */
    @Override
    public String toString() {
        return
                ", studentId=" + userId ;
    }
}
