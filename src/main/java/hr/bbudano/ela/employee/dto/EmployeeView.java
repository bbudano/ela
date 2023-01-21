package hr.bbudano.ela.employee.dto;

import hr.bbudano.ela.employee.model.Role;
import hr.bbudano.ela.team.dto.TeamView;

import java.time.LocalDate;

public record EmployeeView(Long id, String email, String firstName, String lastName,
                           LocalDate dateOfBirth, LocalDate employmentDate, Role role, TeamView team) {
}
