package br.com.linketinder.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 100)
    @NotEmpty(message = "{field.name.required}")
    private String name;

    @Column(name = "email", length = 100)
    @NotEmpty(message = "{field.email.required}")
    private String email;

    @Column(name = "city", length = 50)
    @NotEmpty(message = "{field.city.required}")
    private String city;

    @Column(name = "state_id")
    @NotEmpty(message = "{}") // TODO
    private int stateId;

    @Column(name = "country", length = 50)
    @NotEmpty(message = "{field.country.required}")
    private String country;

    @Column(name = "cep", length = 8)
    @NotEmpty(message = "{field.cep.required}")
    private String cep;

    @Column(name = "description", length = 1000)
    @NotEmpty(message = "{field.description.required}")
    private String description;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message = "{field.cpf.required}")
    private String cpf;

    @OneToMany(mappedBy = "candidate")
    private List<AcademicExperience> academicExperiences;

    @OneToMany(mappedBy = "candidate")
    private List<WorkExperience> workExperiences;

//    @OneToMany(mappedBy = "id")
//    private List<Integer> languages; // TODO

//    @OneToMany(mappedBy = "id")
//    private List<Integer> skills; // TODO

    @OneToMany(mappedBy = "candidate")
    private List<Certificate> certificates;

}
