package br.com.linketinder.auxiliar.controller;

import br.com.linketinder.auxiliar.domain.entity.Skill;
import br.com.linketinder.auxiliar.exception.SkillNotFoundException;
import br.com.linketinder.auxiliar.service.interfaces.ISkillService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/habilidades")
public class SkillController {

    private final ISkillService service;

    public SkillController(ISkillService service) {
        this.service = service;
    }

    @GetMapping
    public List<Skill> getAll() {
        return service.getAllSkills();
    }

    @GetMapping("{id}")
    public Skill getById(@PathVariable Integer id) {
        return service
                .getSkillById(id)
                .orElseThrow(SkillNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Skill createSkill(@RequestBody @Valid Skill skill) {
        return service.createSkill(skill);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Skill skill) {
        Skill existedSkill = service.updateSkill(id, skill);

        if (existedSkill == null) {
            throw new SkillNotFoundException();
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        try {
            service.deleteSkill(id);
        } catch (SkillNotFoundException e) {
            throw new SkillNotFoundException();
        }
    }

}
