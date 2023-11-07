package br.com.linketinder.auxiliar.controller;

import br.com.linketinder.auxiliar.domain.entity.State;
import br.com.linketinder.auxiliar.domain.repository.StateRepository;
import br.com.linketinder.auxiliar.exception.StateNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estados")
public class StateController {

    private final StateRepository repository;

    public StateController(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> getAll() {
        return repository.findAll();
    }

    @GetMapping("{name}")
    public State getByName(@PathVariable String name) {
        Optional<State> state = repository.findOneByAcronym(name);
        if (state.isPresent()) {
            return state.get();
        }
        throw new StateNotFoundException();
    }

}
