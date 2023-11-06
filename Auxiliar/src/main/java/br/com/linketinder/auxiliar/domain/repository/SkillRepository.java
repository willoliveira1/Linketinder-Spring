package br.com.linketinder.auxiliar.domain.repository;

import br.com.linketinder.auxiliar.domain.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
