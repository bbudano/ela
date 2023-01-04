package hr.bbudano.ela.employee.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeView {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private LocalDate employmentDate;

}
