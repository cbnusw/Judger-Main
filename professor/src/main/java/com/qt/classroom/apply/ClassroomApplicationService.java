package com.qt.classroom.apply;

import com.qt.classroom.ClassroomRepository;
import com.qt.classroom.NotFoundClassroomException;
import com.qt.domain.classroom.Classroom;
import com.qt.domain.classroom.ClassroomApplication;
import com.qt.domain.classroom.dto.ClassroomInfo;
import com.qt.domain.user.User;
import com.qt.domain.user.dto.UserInfo;
import com.qt.user.NotFoundUserException;
import com.qt.user.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassroomApplicationService {

    private final ClassroomRepository classroomRepository;
    private final UserRepository userRepository;
    private final ClassroomApplicationRepository classroomApplicationRepository;
    private final ModelMapper modelMapper;

    public ClassroomApplicationService(ClassroomRepository classroomRepository,UserRepository userRepository,ClassroomApplicationRepository classroomApplicationRepository,ModelMapper modelMapper)
    {
        this.classroomRepository=classroomRepository;
        this.userRepository=userRepository;
        this.classroomApplicationRepository=classroomApplicationRepository;
        this.modelMapper=modelMapper;
    }

    public Long apply(Long classroomId,Long userId)
    {
        Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(NotFoundClassroomException::new);
        User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
        return classroomApplicationRepository.save(new ClassroomApplication(classroom, user)).getId();
    }


    @Transactional(readOnly = true)
    public ClassroomApplicationInfo findByClassroomApplicationId(Long classroomApplicationId) {
        ClassroomApplication classroomApplication = classroomApplicationRepository.findById(classroomApplicationId).orElseThrow(NotFoundClassroomApplicationException::new);
        return ClassroomApplicationInfo.builder()
                       .id(classroomApplication.getId())
                       .classroomInfo(modelMapper.map(classroomApplication.getClassroom(), ClassroomInfo.class))
                       .userInfo(modelMapper.map(classroomApplication.getUser(), UserInfo.class))
                       .isApproved(classroomApplication.getIsApproved()).build();
    }

    @Transactional(readOnly = true)
    public List<ClassroomApplicationInfo> findAllByClassroomId(Long classroomId) {
        return classroomApplicationRepository.findAllByClassroomId(classroomId).stream()
                       .map(classroomApplication -> ClassroomApplicationInfo.builder()
                                                          .id(classroomApplication.getId())
                                                          .classroomInfo(modelMapper.map(classroomApplication.getClassroom(), ClassroomInfo.class))
                                                          .userInfo(modelMapper.map(classroomApplication.getUser(), UserInfo.class))
                                                          .isApproved(classroomApplication.getIsApproved()).build())
                       .collect(Collectors.toList());
    }

    public void changeApproveStatus(Long classroomApplicationId) {
        ClassroomApplication classroomApplication= classroomApplicationRepository.findById(classroomApplicationId).orElseThrow(NotFoundClassroomApplicationException::new);
        classroomApplication.changeApproveStatus();
    }


}
