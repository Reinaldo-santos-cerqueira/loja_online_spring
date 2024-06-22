package dev.reinaldosantos.loja.loja_online_spring.domain.address;

public enum AddressType {

    COBRANCA("Cobrança"),
    ENTREGA("Entrega");

    private String description;

    private AddressType (String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return super.toString();
    }

}
