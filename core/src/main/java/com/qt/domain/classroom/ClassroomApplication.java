package com.qt.domain.classroom;

import com.qt.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class ClassroomApplication {

    public ClassroomApplication(@NotNull Classroom classroom, @NotNull User user)
    {
        this.classroom=classroom;
        this.user=user;
    }

    @Id
    @GeneratedValue
    private  Long id;

    @NotNull
    @CreatedBy
    @ManyToOne
    private Classroom classroom;

    @NotNull
    @CreatedBy
    @ManyToOne
    private User user;

    @NotNull
    private Boolean isApproved =false;

    public void changeApproveStatus(){
        isApproved=!isApproved;
    }
}
