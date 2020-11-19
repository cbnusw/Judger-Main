package com.qt.classroom.apply;

import com.qt.classroom.ClassroomRepository;
import com.qt.classroom.NotFoundClassroomException;
import com.qt.domain.classroom.Classroom;
import com.qt.domain.classroom.ClassroomApplication;
import com.qt.domain.user.User;
import com.qt.repository.UserRepository;
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
        User user = userRepository.findById(userId).orElseThrow(RuntimeException::new); //NotFoundException
        return classroomApplicationRepository.save(new ClassroomApplication(classroom, user)).getId();
    }



//    @Transactional(readOnly = true)
//    public ClassroomApplicationInfo findByClassroomApplicationId(Long classroomApplicationId) {
//        ClassroomApplication classroomApplication = classroomApplicationRepository.findById(classroomApplicationId).orElseThrow(NotFoundClassroomApplicationException::new);
//        return ClassroomApplicationInfo.builder()
//                       .id(classroomApplication.getId())
//                       .classroomInfo(modelMapper.map(classroomApplication.getClassroom(), ClassroomInfo.class))
//                       .userInfo(modelMapper.map(classroomApplication.getUser(), UserInfo.class))
//                       .isApproved(classroomApplication.getIsApproved()).build();
//
//
//    }


    //ClassroomApplicationservice에서 classroom별로 user 긁어오기
//    @Transactional(readOnly = true)
//    public List<ClassroomApplicationInfo> findByClassroomId(Long classroomId) {
//        ClassroomApplication classroomApplication = classroomApplicationRepository.findById(classroomId).orElseThrow(NotFoundClassroomApplicationException::new);
//
//        return ;
//    }

    //showcontest's problem
    @Transactional(readOnly = true)
    public List<User> showClassroomApplications(Long classroomId) {
        List<ClassroomApplication> claasroomApplications = classroomApplicationRepository.findAllByClassroomId(classroomId);

        return claasroomApplications.stream()
                       .map(registration -> modelMapper.map(registration.getUser(), User.class))
                       .collect(Collectors.toList());
    }
    //showcontestsproblem
//    @Transactional(readOnly = true)
//    public List<ProblemResponseInfo> showRegisteredProblems(Long contestId) {
//        List<ContestProblemRegistration> contestProblemRegistrations = contestProblemRegistrationRepository.findAllByContestId(contestId);
//
//        return contestProblemRegistrations.stream()
//                       .map(registration -> modelMapper.map(registration.getProblem(), ProblemResponseInfo.class))
//                       .collect(Collectors.toList());
//    }


    //error
//    @Transactional(readOnly = true)
//    public List<ClassroomApplicationInfo> findAllByClassroomId(Long classroomId) {
//        return classroomApplicationRepository.findAllByClassroomId(classroomId).stream()
//                       .map(classroomApplication -> ClassroomApplicationInfo.builder()
//                                                          .id(classroomApplication.getId())
//                                                          .classroom(modelMapper.map(classroomApplication.getClassroom(), ClassroomInfo.class))
//                                                          .userInfo(modelMapper.map(classroomApplication.getUser(), UserInfo.class))
//                                                          .isApproved(classroomApplication.getIsApproved()).build())
//                       .collect(Collectors.toList());
//    }


    @Transactional(readOnly = true)
    public List<ClassroomApplication> findAllByClassroomId2(Long classroomId)
    {
//        return classroomApplicationRepository.findAllByClassroomId(classroomId).stream()
//                       .map(classroomApplication -> ClassroomApplicationInfo.builder()
//                                        .id(classroomApplication.getId())
//                                        .classroom(classroomApplication.getClassroom())
//                                        .user(classroomApplication.getUser())
//                                        .isApproved(classroomApplication.getIsApproved())
//                                        .build())
//                       .collect(Collectors.toList());

        return classroomApplicationRepository.findAllByClassroomId(classroomId);
    }

    //find classroomId and IsApproved
    //Before making, please check ApplicationRepository
//    @Transactional(readOnly = true)
//    public List<ClassroomApplication> findAllByClassroomId3(Long classroomId,Boolean isApproved)
//    {
//
//        return classroomApplicationRepository.findAllByClassroomIdAnAndIsApproved(classroomId,isApproved);
//    }


    @Transactional(readOnly = true)
    public List getApplicationList()
    {
        classroomApplicationRepository.findAll();

        return classroomApplicationRepository.findAll();
    }


    public void changeApproveStatus(Long classroomApplicationId) {
        ClassroomApplication classroomApplication= classroomApplicationRepository.findById(classroomApplicationId).orElseThrow(NotFoundClassroomApplicationException::new);
        classroomApplication.changeApproveStatus();
    }

}
