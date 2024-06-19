package dev.reinaldosantos.loja.loja_online_spring.domain.address;

import java.io.Serializable;

import dev.reinaldosantos.loja.loja_online_spring.domain.person.PersonModel;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
@SequenceGenerator(name="seq_address",sequenceName = "seq_address",initialValue = 1, allocationSize = 1)
public class AddressModel  implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    private Long id;

    private String publicPlace;
    private String cep;
    private String number;
    private String complement;
    private String district;
    private String uf;
    private String city;
    @ManyToOne(targetEntity = PersonModel.class)
    @JoinColumn(name="person_id",nullable=false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fk_person_address"))
    private PersonModel person;  
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AddressModel other = (AddressModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
