package com.qt.classroom.regist;

import com.qt.classroom.ClassroomRepository;
import com.qt.classroom.NotFoundClassroomException;
import com.qt.domain.classroom.Classroom;
import com.qt.domain.classroom.ClassroomHomeworkRegistration;
import com.qt.domain.homework.dto.HomeworkInfo;
import com.qt.homework.HomeworkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ClassroomHomeworkRegistrationService {


    //작업 끝나고 final 붙일것
    private ClassroomRepository classroomRepository;
    private HomeworkRepository homeworkRepository;
    private ClassroomHomeworkRegistrationRepository classroomHomeworkRegistrationRepository;
    private ModelMapper modelMapper;


    public ClassroomHomeworkRegistrationService(ClassroomRepository classroomRepository,HomeworkRepository homeworkRepository,ClassroomHomeworkRegistrationRepository classroomHomeworkRegistrationRepository,ModelMapper modelMapper)
    {
        this.classroomRepository=classroomRepository;
        this.homeworkRepository=homeworkRepository;
        this.classroomRepository=classroomRepository;
        this.modelMapper=modelMapper;
    }
    public void registerHomework(Long classroomId, List<Long> homeworkIds)
    {
        Classroom classroom=classroomRepository.findById(classroomId).orElseThrow(NotFoundClassroomException::new);

        homeworkIds.stream()
                .map(id->homeworkRepository.findById(id).orElseThrow(NotFoundClassroomException::new))
                .forEach(homework -> classroomHomeworkRegistrationRepository.save(new ClassroomHomeworkRegistration(classroom,homework)));
    }


    @Transactional(readOnly = true)
    public List<HomeworkInfo> showRegistrationHomeworks(Long classroomId) {

        List<ClassroomHomeworkRegistration> classroomHomeworkRegistrations=classroomHomeworkRegistrationRepository.findAllByClassroomId(classroomId);

        return classroomHomeworkRegistrations.stream()
                        .map(registration->modelMapper.map(registration.getClassroom(),HomeworkInfo.class))
                        .collect(Collectors.toList());
    }

}
