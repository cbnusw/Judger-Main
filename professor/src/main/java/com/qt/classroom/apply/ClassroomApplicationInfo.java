package com.qt.classroom.apply;

import com.qt.domain.classroom.Classroom;
import com.qt.domain.user.User;
import lombok.Builder;

//public class ClassroomApplicationInfo {
//
//    @NotNull
//    private Long id;
//
//    @NotNull
//    private ClassroomInfo classroomInfo;
//
//    @NotNull
//    private UserInfo userInfo;
//
//    @NotNull
//    private Boolean isApproved;
//
//    @Builder
//    public ClassroomApplicationInfo(@NotNull Long id,@NotNull ClassroomInfo classroomInfo,@NotNull UserInfo userInfo,@NotNull Boolean isApproved)
//    {
//        this.id=id;
//        this.classroomInfo=classroomInfo;
//        this.userInfo=userInfo;
//        this.isApproved=isApproved;
//    }
//}



public class ClassroomApplicationInfo {


    private  Long id;

    private Classroom classroom;

    private User user;

    private Boolean isApproved =false;

    @Builder
    public ClassroomApplicationInfo(Long id, Classroom classroom, User user, Boolean isApproved)
    {
        this.id=id;
        this.classroom=classroom;
        this.user=user;
        this.isApproved=isApproved;
    }
}
