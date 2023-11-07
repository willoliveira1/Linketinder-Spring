package br.com.linketinder.auxiliar.exception;

public class SkillNotFoundException extends RuntimeException {

    public SkillNotFoundException() {
        super("Habilidade não encontrado.");
    }

}
