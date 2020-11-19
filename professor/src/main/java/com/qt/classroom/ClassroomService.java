package com.qt.classroom;

import com.qt.domain.classroom.Classroom;
import com.qt.domain.classroom.dto.ClassroomInfo;
import com.qt.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final ModelMapper modelMapper;

    public ClassroomService(ClassroomRepository classroomRepository,ModelMapper modelMapper)
    {
        this.classroomRepository=classroomRepository;
        this.modelMapper=modelMapper;
    }

    public Long save(ClassroomInfo classroomInfo)
    {
        Classroom classroom=classroomInfo.toEntity();
        return classroomRepository.save(classroom).getId();
    }

    @Transactional(readOnly = true)
    public List<ClassroomInfo> findAll()
    {
        return classroomRepository.findAll().stream()
                .map(classroom -> modelMapper.map(classroom,ClassroomInfo.class))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public ClassroomInfo findById(Long id)
    {
        Classroom classroom=classroomRepository.findById(id).orElseThrow(RuntimeException::new); //NotFoundClassroomException
        return modelMapper.map(classroom,ClassroomInfo.class);
    }

    public Long updateClassroom(Long id,ClassroomInfo classroomInfo)
    {
        Classroom classroom= classroomRepository.findById(id).orElseThrow(RuntimeException::new); //NotFoundClassroomException
        return classroom.updateTo(classroomInfo);
    }


    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}
