package hr.bbudano.ela.employee.service;

import hr.bbudano.ela.employee.dto.CreateEmployeeRequest;
import hr.bbudano.ela.employee.dto.EmployeeView;
import hr.bbudano.ela.employee.dto.UpdateEmployeeRequest;
import hr.bbudano.ela.employee.mapper.EmployeeMapper;
import hr.bbudano.ela.employee.model.Employee;
import hr.bbudano.ela.employee.repository.EmployeeRepository;
import hr.bbudano.ela.exception.ElaException;
import hr.bbudano.ela.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;
    private final EmployeeMapper employeeMapper;

    // REST

    public EmployeeView createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        var employee = employeeMapper.toEmployee(createEmployeeRequest);

        var team = teamRepository.findById(createEmployeeRequest.teamId())
                .orElseThrow(() ->
                        new ElaException("Team not found by id: " + createEmployeeRequest.teamId(), HttpStatus.BAD_REQUEST)
                );

        employee.setTeam(team);

        employeeRepository.saveAndFlush(employee);

        return employeeMapper.toEmployeeView(employee);
    }

    @Transactional(readOnly = true)
    public Page<EmployeeView> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable)
                .map(employeeMapper::toEmployeeView);
    }

    @Transactional(readOnly = true)
    public EmployeeView getEmployee(Long id) {
        var employee = getEmployeeById(id);
        return employeeMapper.toEmployeeView(employee);
    }

    @Transactional
    public EmployeeView updateEmployee(Long id, UpdateEmployeeRequest updateEmployeeRequest) {
        var employee = getEmployeeById(id);

        employeeMapper.mapEmployee(employee, updateEmployeeRequest);

        var team = teamRepository.findById(updateEmployeeRequest.teamId())
                .orElseThrow(() ->
                        new ElaException("Team not found by id: " + updateEmployeeRequest.teamId(), HttpStatus.BAD_REQUEST)
                );

        employee.setTeam(team);

        return employeeMapper.toEmployeeView(employee);
    }

    public void deleteEmployee(Long id) {
        var employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }

    // General

    private Employee getEmployeeById(Long id) {
        return employeeRepository
                .findById(id)
                .orElseThrow(() ->
                        new ElaException("Employee not found by id: " + id, HttpStatus.NOT_FOUND)
                );
    }

}
