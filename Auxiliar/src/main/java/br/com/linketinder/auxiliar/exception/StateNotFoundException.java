package br.com.linketinder.auxiliar.exception;

public class StateNotFoundException extends RuntimeException {

    public StateNotFoundException() {
        super("Estado não encontrado.");
    }

}
