package br.com.linketinder.core.domain.entity;

import br.com.linketinder.core.domain.enums.ContractType;
import br.com.linketinder.core.domain.enums.LocationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="job_vacancies")
public class JobVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title", length = 50)
    @NotEmpty(message = "{field.title.required}")
    private String title;

    @Column(name = "description", length = 2000)
    @NotEmpty(message = "{field.description.required}")
    private String description;

    @Column(name = "salary")
    @NotEmpty(message = "{field.salary.required}")
    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Enumerated(EnumType.STRING)
    @Column(name = "contract_type")
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType locationType;

}
