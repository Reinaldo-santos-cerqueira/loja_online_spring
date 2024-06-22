package dev.reinaldosantos.loja.loja_online_spring.domain.physicalPerson;

import java.util.Date;

import dev.reinaldosantos.loja.loja_online_spring.domain.person.PersonModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="physical_person")
public class PhysicalPersonModel extends PersonModel {
    
    private static final long serialVersionUID = 1L;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    
}
