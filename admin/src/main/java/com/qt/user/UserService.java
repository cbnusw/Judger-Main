package com.qt.user;

import com.qt.domain.user.dto.UserInfo;
import com.qt.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional(readOnly = true)
    public List<UserInfo> findAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> modelMapper.map(user, UserInfo.class))
                .collect(Collectors.toList());
    }
}
