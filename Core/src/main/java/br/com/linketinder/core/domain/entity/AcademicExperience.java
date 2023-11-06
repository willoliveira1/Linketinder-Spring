package br.com.linketinder.core.domain.entity;

import br.com.linketinder.core.domain.enums.CourseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="academic_experiences")
public class AcademicExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "educational_institution", length = 50)
    @NotEmpty(message = "{field.educational_institution.required}")
    private String educationalInstitution;

    @Column(name = "degree_type", length = 50)
    @NotEmpty(message = "{field.degree_type.required}")
    private String degreeType;

    @Column(name = "field_of_study", length = 50)
    @NotEmpty(message = "{field.field_of_study.required}")
    private String fieldOfStudy;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    @Column(name = "course_status")
    private CourseStatus courseStatus;

}
