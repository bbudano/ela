package hr.bbudano.ela.team.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "team", uniqueConstraints = {
        @UniqueConstraint(name = "team_name_unique", columnNames = { "name" }) })
public class Team {

    @Id
    @SequenceGenerator(name = "team_id_seq_generator", sequenceName = "team_id_seq",
            initialValue = 10, allocationSize = 10)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "team_id_seq_generator")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "base_allowance", nullable = false)
    private Integer baseAllowance;

}
