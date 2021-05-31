package br.com.luisfga.sandbox.apis.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
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
public class Address implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @NotBlank
    @Column(name = "postal_code")
    private String postalCode;
    
    @NotBlank private String street;
    @NotBlank private String district;
    @NotBlank private String city;
    @NotBlank private String state;
    @NotBlank private String country;

    private String number;
    private String complement;
    
    @CreationTimestamp
    private LocalDate localDate;
    
    @ManyToOne
    @JoinColumn(name = "username")    
    private AppUser appUser;

}
