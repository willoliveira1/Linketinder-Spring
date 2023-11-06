package br.com.linketinder.auxiliar.controller;

import br.com.linketinder.auxiliar.domain.entity.Language;
import br.com.linketinder.auxiliar.exception.LanguageNotFoundException;
import br.com.linketinder.auxiliar.service.interfaces.ILanguageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/idiomas")
public class LanguageController {

    private final ILanguageService service;

    public LanguageController(ILanguageService service) {
        this.service = service;
    }

    @GetMapping
    public List<Language> getAll() {
        return service.getAllLanguages();
    }

    @GetMapping("{id}")
    public Language getById(@PathVariable Integer id) {
        return service
                .getLanguageById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND, "{language.not-found}"));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Language createLanguage(@RequestBody @Valid Language language) {
        return service.createLanguage(language);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid Language language) {
        Language existedLanguage = service.updateLanguage(id, language);

        if (existedLanguage == null) {
            throw new ResponseStatusException(NOT_FOUND, "{language.not-found}");
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        try {
            service.deleteLanguage(id);
        } catch (LanguageNotFoundException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }

}
