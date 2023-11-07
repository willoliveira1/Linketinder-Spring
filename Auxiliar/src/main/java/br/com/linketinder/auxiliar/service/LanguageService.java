package br.com.linketinder.auxiliar.service;

import br.com.linketinder.auxiliar.domain.entity.Language;
import br.com.linketinder.auxiliar.domain.repository.LanguageRepository;
import br.com.linketinder.auxiliar.exception.LanguageNotFoundException;
import br.com.linketinder.auxiliar.service.interfaces.ILanguageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService implements ILanguageService {

    private LanguageRepository repository;

    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Language> getAllLanguages() {
        return repository.findAll();
    }

    @Override
    public Optional<Language> getLanguageById(int id) {
        return repository.findById(id);
    }

    @Override
    public Language createLanguage(Language language) {
        return repository.save(language);
    }

    @Override
    public Language updateLanguage(int id, Language languageDetails) {
        Optional<Language> language = repository.findById(id);

        if (language.isPresent()) {
            Language existedLanguage = language.get();
            existedLanguage.setName(languageDetails.getName());
            return repository.save(existedLanguage);
        }
        return null;
    }

    @Override
    public void deleteLanguage(int id) {
        Optional<Language> language = repository.findById(id);

        if (language.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new LanguageNotFoundException();
        }
    }

}
