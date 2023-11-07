package br.com.linketinder.auxiliar.service.interfaces;

import br.com.linketinder.auxiliar.domain.entity.Language;
import java.util.List;
import java.util.Optional;

public interface ILanguageService {

    List<Language> getAllLanguages();
    Optional<Language> getLanguageById(int id);
    Language createLanguage(Language language);
    Language updateLanguage(int id, Language languageDetails);
    void deleteLanguage(int id);

}
