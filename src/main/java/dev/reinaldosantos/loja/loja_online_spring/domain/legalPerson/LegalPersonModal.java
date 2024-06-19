package dev.reinaldosantos.loja.loja_online_spring.domain.legalPerson;

import dev.reinaldosantos.loja.loja_online_spring.domain.person.PersonModel;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="physicalPeople")
@PrimaryKeyJoinColumn(name="id")
public class LegalPersonModal extends PersonModel {
    private String cnpj;
    private String municipalRegistration;
    private String fantasyName;
    private String corporateReason;
    private String category;
    
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getMunicipalRegistration() {
        return municipalRegistration;
    }
    public void setMunicipalRegistration(String municipalRegistration) {
        this.municipalRegistration = municipalRegistration;
    }
    public String getFantasyName() {
        return fantasyName;
    }
    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }
    public String getCorporateReason() {
        return corporateReason;
    }
    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    private String stateRegistration;
    public String getStateRegistration() {
        return stateRegistration;
    }
    public void setStateRegistration(String stateRegistration) {
        this.stateRegistration = stateRegistration;
    }

}
