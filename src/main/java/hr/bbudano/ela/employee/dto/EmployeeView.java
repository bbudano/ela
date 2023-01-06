package hr.bbudano.ela.employee.dto;

import java.time.LocalDate;

public record EmployeeView(Long id, String email, String firstName, String lastName,
                           LocalDate dateOfBirth, LocalDate employmentDate) {
}
