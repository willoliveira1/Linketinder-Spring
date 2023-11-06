package br.com.linketinder.auxiliar.domain.repository;

import br.com.linketinder.auxiliar.domain.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StateRepository extends JpaRepository<State, Integer> {

    @Query("SELECT s FROM State s WHERE lower(s.acronym) = lower(?1)")
    Optional<State> findOneByAcronym(String acronym);

}
