package hr.bbudano.ela.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(name = "employee_email_unique",columnNames = { "email" }) })
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_id_seq_generator", sequenceName = "employee_id_seq",
            initialValue = 10, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "employee_id_seq_generator")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "employment_date")
    private LocalDate employmentDate;

}
