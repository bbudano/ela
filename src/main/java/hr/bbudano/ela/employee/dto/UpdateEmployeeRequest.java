package hr.bbudano.ela.employee.dto;

import hr.bbudano.ela.employee.model.Role;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateEmployeeRequest(@NotNull(message = "Email can not be null") String email,
                                    @NotNull(message = "First name can not be null") String firstName,
                                    @NotNull(message = "Last name can not be null") String lastName,
                                    @NotNull(message = "Date of birth can not be null") LocalDate dateOfBirth,
                                    @NotNull(message = "Employment date can not be null") LocalDate employmentDate,
                                    @NotNull(message = "Team id can not be null") Long teamId,
                                    Role role) {
}
