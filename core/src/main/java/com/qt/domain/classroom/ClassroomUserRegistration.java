package com.qt.domain.classroom;

import com.qt.domain.user.User;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class ClassroomUserRegistration {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Classroom classroom;

    @NotNull
    @ManyToOne
    private User user;

    public ClassroomUserRegistration(@NotNull Classroom classroom, @NotNull User user)
    {
        this.classroom=classroom;
        this.user=user;
    }
}
