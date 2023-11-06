package br.com.linketinder.auxiliar.service.interfaces;

import br.com.linketinder.auxiliar.domain.entity.Skill;
import java.util.List;
import java.util.Optional;

public interface ISkillService {

    List<Skill> getAllSkills();
    Optional<Skill> getSkillById(int id);
    Skill createSkill(Skill skill);
    Skill updateSkill(int id, Skill skillDetails);
    void deleteSkill(int id);

}
