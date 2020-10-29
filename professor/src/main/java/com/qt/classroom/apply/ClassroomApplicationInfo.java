package com.qt.classroom.apply;

import com.qt.domain.classroom.dto.ClassroomInfo;
import com.qt.domain.user.dto.UserInfo;
import lombok.Builder;

import javax.validation.constraints.NotNull;

public class ClassroomApplicationInfo {

    @NotNull
    private Long id;

    @NotNull
    private ClassroomInfo classroomInfo;

    @NotNull
    private UserInfo userInfo;

    @NotNull
    private Boolean isApproved;

    @Builder
    public ClassroomApplicationInfo(@NotNull Long id,@NotNull ClassroomInfo classroomInfo,@NotNull UserInfo userInfo,@NotNull Boolean isApproved)
    {
        this.id=id;
        this.classroomInfo=classroomInfo;
        this.userInfo=userInfo;
        this.isApproved=isApproved;
    }
}
