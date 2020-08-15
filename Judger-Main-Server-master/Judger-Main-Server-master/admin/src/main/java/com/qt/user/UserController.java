package com.qt.user;

import com.qt.domain.user.dto.UserInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //모든 유저들의 정보 조회
    @GetMapping
    public ResponseEntity<List<UserInfo>> findAllUsers() {
        List<UserInfo> userInfos = userService.findAllUsers();
        return ResponseEntity.ok(userInfos);
    }
}
