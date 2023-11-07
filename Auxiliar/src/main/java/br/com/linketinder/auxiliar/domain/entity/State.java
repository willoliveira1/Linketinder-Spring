package br.com.linketinder.auxiliar.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "acronym", length = 50)
    private String acronym;

    @Column(name = "name", length = 50)
    private String name;

//    public StateEntity() {
//    }

//    public StateEntity(String acronym, String title) {
//        this.acronym = acronym;
//        this.title = title;
//    }
//
//    public String getAcronym() {
//        return acronym;
//    }
//
//    public String getName() {
//        return name;
//    }

}
