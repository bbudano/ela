package hr.bbudano.ela.employee.mapper;

import hr.bbudano.ela.employee.dto.CreateEmployeeRequest;
import hr.bbudano.ela.employee.dto.EmployeeView;
import hr.bbudano.ela.employee.dto.UpdateEmployeeRequest;
import hr.bbudano.ela.employee.model.Employee;
import hr.bbudano.ela.team.mapper.TeamMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN, uses = { TeamMapper.class })
public interface EmployeeMapper {

    @Mapping(target = "team", source = "team", qualifiedByName = "toTeamView")
    EmployeeView toEmployeeView(Employee employee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    Employee toEmployee(CreateEmployeeRequest createEmployeeRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    void mapEmployee(@MappingTarget Employee employee, UpdateEmployeeRequest updateEmployeeRequest);

}
