package br.com.linketinder.core.domain.entity;

import br.com.linketinder.core.domain.enums.CourseStatus;
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
@Table(name="companies")
public class Company {

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

    @Column(name = "cnpj", length = 14)
    @NotEmpty(message = "{field.cnpj.required}")
    private String cnpj;

    @OneToMany(mappedBy = "id")
    private List<JobVacancy> jobVacancies;

//    @OneToMany(mappedBy = "id")
//    private List<Integer> benefits; // TODO

}
