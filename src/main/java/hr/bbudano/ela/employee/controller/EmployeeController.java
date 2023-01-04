package hr.bbudano.ela.employee.controller;

import hr.bbudano.ela.employee.dto.EmployeeView;
import hr.bbudano.ela.employee.mapper.EmployeeMapper;
import hr.bbudano.ela.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public Page<EmployeeView> getEmployees(Pageable pageable) {
        return employeeService
                .getEmployees(pageable)
                .map(employeeMapper::toEmployeeView);
    }

    @GetMapping("/{id}")
    public EmployeeView getEmployee(@PathVariable Long id) {
        var employee = employeeService.getEmployee(id);
        return employeeMapper.toEmployeeView(employee);
    }

}
