package com.qt.login;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginCotroller {
    LoginService loginService;

    public LoginCotroller(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login/{id}/{pw}")
    public ResponseEntity login(@PathVariable("id") String id, @PathVariable("pw") String pw){
            String response=loginService.check(id,pw);
            return ResponseEntity.ok(response);
    }
}
