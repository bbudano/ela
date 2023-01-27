package hr.bbudano.ela.security.config;

import hr.bbudano.ela.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@AllArgsConstructor
public class CustomOAuth2User implements OAuth2User {

    @Getter
    private Long id;

    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    private Map<String, Object> attributes;

    public static CustomOAuth2User extendOAuth2User(Employee employee, Map<String, Object> attributes) {
        return new CustomOAuth2User(
                employee.getId(),
                employee.getEmail(),
                Collections.singletonList(new SimpleGrantedAuthority(employee.getRole().name())),
                attributes
        );
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getName() {
        return email;
    }

}
