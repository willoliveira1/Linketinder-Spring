package br.com.linketinder.auxiliar.domain.repository;

import br.com.linketinder.auxiliar.domain.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
}
