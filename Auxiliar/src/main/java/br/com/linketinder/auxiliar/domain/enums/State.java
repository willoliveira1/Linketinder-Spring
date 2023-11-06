package br.com.linketinder.auxiliar.domain.enums;

public enum State {

    AC ("Acre"),
    AL ("Alagoas"),
    AM ("Amazonas"),
    AP ("Amapá"),
    BA ("Bahia"),
    CE ("Ceará"),
    DF ("Distrito Federal"),
    ES ("Espírito Santo"),
    GO ("Goiás"),
    MA ("Maranhão"),
    MG ("Minas Gerais"),
    MT ("Mato Grosso"),
    MS ("Mato Grosso do Sul"),
    PA ("Pará"),
    PB ("Paraíba"),
    PE ("Pernambuco"),
    PI ("Piauí"),
    PR ("Paraná"),
    RJ ("Rio de Janeiro"),
    RN ("Rio Grande do Norte"),
    RO ("Rondônia"),
    RR ("Roraima"),
    RS ("Rio Grande do Sul"),
    SC ("Santa Catarina"),
    SE ("Sergipe"),
    SP ("São Paulo"),
    TO ("Tocantins");

    private final String title;

    State(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAcronym() {
        return name();
    }

}
