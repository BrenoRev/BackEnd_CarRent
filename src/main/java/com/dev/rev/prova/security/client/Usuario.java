package com.dev.rev.prova.security.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
public class Usuario implements UserDetails{
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private Long id;

    @Column(name = "user_login", unique = true)
    private String login;

    @Column(name = "user_password")
    private String senha;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToMany(fetch = FetchType.EAGER)
 // Criar uma tabela no banco de dados com o id do usuario e o id da role que ele tem
 	@JoinTable(name = "usuarios_role", uniqueConstraints = @UniqueConstraint(
 	columnNames = {"usuario_id", "role_id"}, name="unique_role_user"), 
 	joinColumns = @JoinColumn(name = "usuario_id" , referencedColumnName = "id" , table="usuario", unique = false,
 	foreignKey = @ForeignKey (name = "usuario_fk", value = ConstraintMode.CONSTRAINT)),
 	inverseJoinColumns = @JoinColumn (name = "role_id", referencedColumnName = "id",
 	table = "role", unique = false, updatable = false,
 	foreignKey = @ForeignKey (name="role_fk" , value = ConstraintMode.CONSTRAINT)))
    private List<Role> roles = new ArrayList<>(); /* Os Acessos */

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "user_token")
    private String token = "";

    /* Autorizações, os acessos do usuário ROLE_ADMIN ou ROLE_USUARIO e etc.*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }


    @Override
    public String getUsername() {
        return this.login;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(id, other.id);
    }

}