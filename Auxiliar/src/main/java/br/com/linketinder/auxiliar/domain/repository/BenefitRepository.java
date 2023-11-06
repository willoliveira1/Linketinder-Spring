package br.com.linketinder.auxiliar.domain.repository;

import br.com.linketinder.auxiliar.domain.entity.Benefit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BenefitRepository extends JpaRepository<Benefit, Integer> {
}
