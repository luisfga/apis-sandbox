package br.com.luisfga.sandbox.apis.domain;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//TODO definir um novo mecanismo de criar staticamente roles da App e mantê-las no banco

@Entity
@Table(name = "app_role")
@Getter @Setter @NoArgsConstructor
public class AppRole implements Serializable {
    
    @Id @NotBlank
    @Column(name = "role_name")
    private String roleName;
    
    @ManyToMany(mappedBy = "roles")
    private Set<AppUser> users;

}