package com.qt.homework;

import com.qt.classroom.ClassroomRepository;
import com.qt.domain.homework.Homework;
import com.qt.domain.homework.dto.FileInfo;
import com.qt.domain.homework.dto.HomeworkInfo;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class HomeworkService {

    //Server 연동시 바꿔줄것(Linux 환경에서 교체)
    private static final String LOCAL_PROBLEM_STORAGE_PATH = "C:/Users/ygkwo/Desktop/test"; //PATH (Desktop 기준)

    private static final String FILE_PATH = "file:";


    private final ClassroomRepository classroomRepository;
    private final HomeworkRepository homeworkRepository;
    private final ModelMapper modelMapper;
    private final ResourceLoader resourceLoader;


    public HomeworkService(ClassroomRepository classroomRepository,HomeworkRepository homeworkRepository,ModelMapper modelMapper,ResourceLoader resourceLoader)
    {
        this.classroomRepository=classroomRepository;
        this.homeworkRepository=homeworkRepository;
        this.modelMapper=modelMapper;
        this.resourceLoader=resourceLoader;
    }


    public List<HomeworkInfo> findAll() {
        return homeworkRepository.findAll().stream()
                       .map(homework -> modelMapper.map(homework, HomeworkInfo.class))
                       .collect(Collectors.toList());
    }


    public Long save(HomeworkInfo homeworkInfo, MultipartFile file) throws IOException {
        String identifier = saveHomeworkFile(file, homeworkInfo.getHomeworkName());

        Homework homework = new Homework(homeworkInfo.getSubjectNumber(),homeworkInfo.getHomeworkName(), identifier, homeworkInfo.getHomeworkDescription(), homeworkInfo.getEndDate(),homeworkInfo.getEndTime());
        return homeworkRepository.save(homework).getId();
    }

    @Transactional(readOnly = true)
    public HomeworkInfo findById(Long id)
    {
        return homeworkRepository
                       .findById(id)
                       .map(homework-> modelMapper.map(homework,HomeworkInfo.class))
                       .orElseThrow(NotFoundHomeworkException::new);

    }

    @Transactional(readOnly = true)
    public FileInfo findHomeworkFile(Long id) throws IOException{
        Homework homework=homeworkRepository.findById(id).orElseThrow(NotFoundHomeworkException::new);
        String identifier= homework.getIdentifier();
        //PATH+identifier
        Resource resource=resourceLoader.getResource(FILE_PATH+LOCAL_PROBLEM_STORAGE_PATH  +"/" + homework.getHomeworkName());

        return FileInfo.builder()
                        .contentDisposition(homework.getHomeworkName())
                        .contentLength(String.valueOf(resource.getFile().length()))
                        .resource(resource)
                        .build();
    }


    public Long updateHomework(Long id, HomeworkInfo homeworkInfo, MultipartFile file) throws IOException {

        Homework homework= deleteHomeworkFile(id);

        String identifier =saveHomeworkFile(file,homeworkInfo.getHomeworkName());
        //Homework 클래스의 updateTo 함수 수정할것!!
        return homework.updateTo(identifier,homeworkInfo);
    }


    public void deleteHomework(Long id) throws  IOException{
        Homework homework=deleteHomeworkFile(id);
        homeworkRepository.delete(homework);
    }

    private String saveHomeworkFile(MultipartFile file, String name) throws IOException {
        String identifier = UUID.randomUUID().toString();
        String directory = LOCAL_PROBLEM_STORAGE_PATH ; //+identifier
        new File(directory).mkdir();

        File dest = new File(directory + "/" + name);
        file.transferTo(dest);
        return identifier;
    }

    private Homework deleteHomeworkFile(Long id) throws IOException {
        Homework homework = homeworkRepository.findById(id).orElseThrow(NotFoundHomeworkException::new);
        Resource resource = resourceLoader.getResource(FILE_PATH + LOCAL_PROBLEM_STORAGE_PATH + homework.getIdentifier());
        resource.getFile().delete();
        return homework;
    }

}
