package hr.bbudano.ela.security;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    @GetMapping("/profile")
    public Map<String, Object> getUserInfo(Authentication authentication) {
        return Collections.singletonMap("name", authentication.getName());
    }

}
