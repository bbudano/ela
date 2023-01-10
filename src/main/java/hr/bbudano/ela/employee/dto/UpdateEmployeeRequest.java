package hr.bbudano.ela.employee.dto;

import java.time.LocalDate;

public record UpdateEmployeeRequest(String email, String firstName, String lastName, LocalDate dateOfBirth,
                                    LocalDate employmentDate) {
}
