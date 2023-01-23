package hr.bbudano.ela.security.config;

import hr.bbudano.ela.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final EmployeeRepository employeeRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        var oAuth2User = super.loadUser(oAuth2UserRequest);

        var employee = employeeRepository.findByEmail(oAuth2User.getAttribute("email"))
                .orElseThrow(() -> new InternalAuthenticationServiceException("You do not have access to this resource."));

        if (oAuth2User.getAttribute("picture") != employee.getImageUrl()) {
            employee.setImageUrl(oAuth2User.getAttribute("picture"));
        }

        employeeRepository.saveAndFlush(employee);

        return oAuth2User;
    }

}
