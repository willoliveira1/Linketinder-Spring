package br.com.linketinder.auxiliar.service;

import br.com.linketinder.auxiliar.domain.entity.Skill;
import br.com.linketinder.auxiliar.domain.repository.SkillRepository;
import br.com.linketinder.auxiliar.exception.SkillNotFoundException;
import br.com.linketinder.auxiliar.service.interfaces.ISkillService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements ISkillService {

    private SkillRepository repository;

    public SkillService(SkillRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    @Override
    public Optional<Skill> getSkillById(int id) {
        return repository.findById(id);
    }

    @Override
    public Skill createSkill(Skill skill) {
        return repository.save(skill);
    }

    @Override
    public Skill updateSkill(int id, Skill skillDetails) {
        Optional<Skill> skill = repository.findById(id);

        if (skill.isPresent()) {
            Skill existedSkill = skill.get();
            existedSkill.setTitle(skillDetails.getTitle());
            return repository.save(existedSkill);
        }
        return null;
    }

    @Override
    public void deleteSkill(int id) {
        Optional<Skill> skill = repository.findById(id);

        if (skill.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new SkillNotFoundException();
        }
    }

}
