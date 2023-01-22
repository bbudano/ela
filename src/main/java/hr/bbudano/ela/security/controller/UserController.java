package hr.bbudano.ela.security.controller;

import hr.bbudano.ela.security.Role;
import hr.bbudano.ela.security.dto.UserProfileDto;
import hr.bbudano.ela.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public UserProfileDto getUserInfo(Authentication authentication) {
        return userService.getUserProfile(authentication.getName());
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

}
