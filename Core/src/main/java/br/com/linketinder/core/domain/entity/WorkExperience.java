package br.com.linketinder.core.domain.entity;

import br.com.linketinder.core.domain.entity.Candidate;
import br.com.linketinder.core.domain.enums.ContractType;
import br.com.linketinder.core.domain.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="work_experiences")
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 50)
    @NotEmpty(message = "{field.title.required}")
    private String title;

    @Column(name = "company_name", length = 50)
    @NotEmpty(message = "{field.company_name.required}")
    private String companyName;

    @Column(name = "city", length = 50)
    @NotEmpty(message = "{field.city.required}")
    private String city;

    @Column(name = "currently_work")
    @NotEmpty(message = "{field.currently_work.required}")
    private Boolean currentlyWork;

    @Column(name = "description", length = 1000)
    @NotEmpty(message = "{field.description.required}")
    private String description;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name = "state_id")
    @NotEmpty(message = "{}") // TODO
    private int stateId;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType locationType;

}
