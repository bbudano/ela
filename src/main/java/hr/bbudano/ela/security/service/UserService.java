package hr.bbudano.ela.security.service;

import hr.bbudano.ela.employee.mapper.EmployeeMapper;
import hr.bbudano.ela.employee.repository.EmployeeRepository;
import hr.bbudano.ela.exception.ElaException;
import hr.bbudano.ela.security.dto.UserProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public UserProfileDto getUserProfile(String principal) {
        var employee = employeeRepository.findByEmail(principal)
                .orElseThrow(() -> new ElaException("Employee not found: " + principal, HttpStatus.INTERNAL_SERVER_ERROR));

        return employeeMapper.toUserProfileDto(employee);
    }

}
