package br.com.linketinder.auxiliar.exception;

public class BenefitNotFoundException extends RuntimeException {

    public BenefitNotFoundException() {
        super("{benefit.not-found}");
    }

}
