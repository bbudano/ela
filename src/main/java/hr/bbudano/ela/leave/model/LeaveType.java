package hr.bbudano.ela.leave.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leave_type", uniqueConstraints = {
        @UniqueConstraint(name = "leave_type_unique", columnNames = {"name"})})
public class LeaveType {

    @Id
    @SequenceGenerator(name = "leave_type_id_seq_generator", sequenceName = "leave_type_id_seq",
            initialValue = 10, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "leave_type_id_seq_generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "deducts_allowance", nullable = false)
    private Boolean deductsAllowance;

}
