package com.qt.problem;

import com.qt.domain.problem.Problem;
import com.qt.domain.problem.dto.FileInfo;
import com.qt.domain.problem.dto.ProblemRequestInfo;
import com.qt.domain.problem.dto.ProblemResponseInfo;
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
public class ProblemService {
    private static final String LOCAL_PROBLEM_STORAGE_PATH = "C:\\Users\\jtm06\\javaProject\\git_home\\Judger-Main-Server-master\\Judger-Main-Server-master\\admin\\src\\main\\resources\\problems";

    private static final String FILE_PATH = "file:";

    private final ProblemRepository problemRepository;
    private final ModelMapper modelMapper;
    private final ResourceLoader resourceLoader;

    public ProblemService(ProblemRepository problemRepository, ModelMapper modelMapper, ResourceLoader resourceLoader) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
        this.resourceLoader = resourceLoader;
    }

    public List<ProblemResponseInfo> findAll() {
        return problemRepository.findAll().stream()
                .map(problem -> modelMapper.map(problem, ProblemResponseInfo.class))
                .collect(Collectors.toList());
    }

    public Long save(ProblemRequestInfo problemRequestInfo, MultipartFile file) throws IOException {
        //String identifier = saveProblemFile(file, problemRequestInfo.getName());

        Problem problem = new Problem(problemRequestInfo.getName(), problemRequestInfo.getTimeLimit(), problemRequestInfo.getMemoryLimit());

        Long problem_id =problemRepository.save(problem).getId();
        saveProblemFile(file,problemRequestInfo.getName(),problem_id);
        return problem_id;
    }

    @Transactional(readOnly = true)
    public ProblemResponseInfo findById(Long id) {
        return problemRepository
                .findById(id)
                .map(problem -> modelMapper.map(problem, ProblemResponseInfo.class))
                .orElseThrow(NotFoundProblemException::new);
    }

    @Transactional(readOnly = true)
    public FileInfo findProblemFile(Long id) throws IOException {
        Problem problem = problemRepository.findById(id).orElseThrow(NotFoundProblemException::new);
        //String identifier = problem.getIdentifier();
        Resource resource = resourceLoader.getResource(FILE_PATH + LOCAL_PROBLEM_STORAGE_PATH + problem.getId() + "/" + problem.getName());

        return FileInfo.builder()
                .contentDisposition(problem.getName())
                .contentLength(String.valueOf(resource.getFile().length()))
                .resource(resource)
                .build();
    }

    public Long updateProblem(Long id, ProblemRequestInfo problemRequestInfo, MultipartFile file) throws IOException {
        Problem problem = deleteProblemFile(id);

        saveProblemFile(file, problemRequestInfo.getName(),problem.getId());
        return problem.updateTo( problemRequestInfo);
    }

    public void deleteProblem(Long id) throws IOException {
        Problem problem = deleteProblemFile(id);
        problemRepository.delete(problem);
    }

    private void saveProblemFile(MultipartFile file, String name, long id) throws IOException {
        //String identifier = UUID.randomUUID().toString();
        System.out.println("테스트: "+id);
        String directory = LOCAL_PROBLEM_STORAGE_PATH + id;
        new File(directory).mkdir();

        File dest = new File(directory + "/" + name);
        file.transferTo(dest);
        //return identifier;
    }

    private Problem deleteProblemFile(Long id) throws IOException {
        Problem problem = problemRepository.findById(id).orElseThrow(NotFoundProblemException::new);
        Resource resource = resourceLoader.getResource(FILE_PATH + LOCAL_PROBLEM_STORAGE_PATH + problem.getId());
        resource.getFile().delete();
        return problem;
    }
}
