//package com.qt.classroom.regist;
//
//import com.qt.classroom.ClassroomRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//
//@Service
//@Transactional
//public class ClassroomHomeworkRegistrationService {
//
//
//    //작업 끝나고 final 붙일것
//    private ClassroomRepository classroomRepository;
//    private ClassroomHomeworkRegistrationRepository classroomHomeworkRegistrationRepository;
//    private ModelMapper modelMapper;
//
//
////    public ClassroomHomeworkRegistrationService(ClassroomRepository classroomRepository,ClassroomHomeworkRegistrationRepository classroomHomeworkRegistrationRepository,ModelMapper modelMapper)                                           )
////    {
////        this.classroomRepository=classroomRepository;
////        this.classroomHomeworkRegistrationRepository=classroomHomeworkRegistrationRepository;
////        this.modelMapper=modelMapper;
////    }
//
//    //마져 완성 시킬것  => return 없어서 빨간줄 뜨는거임
////    public Long Apply(Long classroomId,Long homeworkId)
////    {
////
////        Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(NotFoundClassroomException::new);
////        //Homework homework
////        //User user = userRepository.findById(userId).orElseThrow(NotFoundUserException::new);
////        //return classroomApplicationRepository.save(new ClassroomApplication(classroom, user)).getId();
////    }
//}
