package dev.reinaldosantos.loja.loja_online_spring.domain.user;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dev.reinaldosantos.loja.loja_online_spring.domain.access.AccessModel;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seq_users", sequenceName = "seq_users",allocationSize = 1, initialValue = 1)
public class UserModel   implements  UserDetails {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long id;

    private String password;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCurrent() {
        return dateCurrent;
    }

    public void setDateCurrent(Date dateCurrent) {
        this.dateCurrent = dateCurrent;
    }

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    private Date dateCurrent;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_access",
        uniqueConstraints = @UniqueConstraint(
            columnNames = { "users_id", "access_id" },
            name = "unique_access_users"
        ),
        joinColumns = @JoinColumn(
            name = "users_id",
            referencedColumnName = "id",
            table = "users",
            unique = false,
            foreignKey = @ForeignKey(
                name = "fk_users",
                value = ConstraintMode.CONSTRAINT
            )
        ),
        inverseJoinColumns = @JoinColumn(
            name = "access_id",
            referencedColumnName = "id",
            table = "access",
            unique = false,
            foreignKey = @ForeignKey(
                name = "fk_access",
                value = ConstraintMode.CONSTRAINT
            )
        )
    )
    private List<AccessModel> accesses;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.accesses;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }
    
}
