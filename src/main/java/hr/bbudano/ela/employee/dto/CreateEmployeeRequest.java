package hr.bbudano.ela.employee.dto;

import java.time.LocalDate;

public record CreateEmployeeRequest(String email, String firstName, String lastName, LocalDate dateOfBirth,
                                    LocalDate employmentDate, Long teamId) {
}
