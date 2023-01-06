package hr.bbudano.ela.employee.mapper;

import hr.bbudano.ela.employee.dto.CreateEmployeeRequest;
import hr.bbudano.ela.employee.dto.EmployeeView;
import hr.bbudano.ela.employee.dto.UpdateEmployeeRequest;
import hr.bbudano.ela.employee.model.Employee;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EmployeeMapper {

    EmployeeView toEmployeeView(Employee employee);

    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest);

    void updateEmployee(@MappingTarget Employee employee, UpdateEmployeeRequest updateEmployeeRequest);

}
