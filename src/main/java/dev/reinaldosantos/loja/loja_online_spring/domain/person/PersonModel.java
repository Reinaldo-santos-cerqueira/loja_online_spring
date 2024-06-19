package dev.reinaldosantos.loja.loja_online_spring.domain.person;

import java.io.Serializable;
import java.util.List;

import dev.reinaldosantos.loja.loja_online_spring.domain.address.AddressModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name="seq_people",sequenceName = "seq_people",initialValue = 1, allocationSize = 1)
public class PersonModel  implements Serializable{
    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "person")
    
    private List<AddressModel> address;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_people")
    private Long id;

    private String name;
    private String email;
    private String phone;
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
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
        PersonModel other = (PersonModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
