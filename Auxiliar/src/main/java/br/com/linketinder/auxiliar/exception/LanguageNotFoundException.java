package br.com.linketinder.auxiliar.exception;

public class LanguageNotFoundException extends RuntimeException {

    public LanguageNotFoundException() {
        super("{language.not-found}");
    }

}
