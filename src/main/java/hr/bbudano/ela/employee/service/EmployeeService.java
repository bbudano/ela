package hr.bbudano.ela.employee.service;

import hr.bbudano.ela.employee.model.Employee;
import hr.bbudano.ela.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployee(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found by id: " + id));
    }

}
