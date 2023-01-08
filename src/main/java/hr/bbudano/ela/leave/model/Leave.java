package hr.bbudano.ela.leave.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "leave")
public class Leave {

    @Id
    @SequenceGenerator(name = "leave_id_seq_generator", sequenceName = "leave_id_seq",
            initialValue = 10, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "leave_id_seq_generator")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveType leaveType;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

}
