package br.com.luisfga.sandbox.apis.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author luisfga
 */
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name = "app_user")
public class AppUser implements Serializable {
    
    @Id @GeneratedValue
    private long id;
    
    @Email
    private String username;
    
    @Size(min = 3, max = 64)
    private String password;
    
    @NotBlank
    private String name;
    
    @Size(min = 11, max = 11)
    private String cpf;
    
    private byte[] thumbnail;

    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate birthday;
    
    @CreationTimestamp
    @Column(name="create_at")
    private OffsetDateTime createdAt;
    
    @Size(min = 10)
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @NotEmpty
    private UserStatus status = UserStatus.NEW;
    public enum UserStatus{NEW, VERIFIED, BLOCKED, BANNED}
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role", 
            joinColumns = @JoinColumn(name = "username"), 
            inverseJoinColumns = @JoinColumn(name = "role_name"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"username","role_name"})
    )
    private Set<AppRole> roles = new HashSet<>();
    
    @OrderBy("localDate ASC")
    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

}