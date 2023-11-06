package br.com.linketinder.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="certificates")
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 50)
    @NotEmpty(message = "{field.title.required}")
    private String title;

    @Column(name = "duration", length = 50)
    @NotEmpty(message = "{field.duration.required}")
    private String duration;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

}
