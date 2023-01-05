package hr.bbudano.ela.employee.mapper;

import hr.bbudano.ela.employee.dto.CreateEmployeeRequest;
import hr.bbudano.ela.employee.dto.EmployeeView;
import hr.bbudano.ela.employee.model.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.WARN)
public interface EmployeeMapper {

    EmployeeView toEmployeeView(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest);

}
