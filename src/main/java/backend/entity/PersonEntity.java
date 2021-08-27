package backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 *
 * @author mohamad
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="person")
public class PersonEntity {
    
   @Id 
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;

   @NotBlank(message = "Name may not be empty or null")
   private String nome;
   
   @NotBlank(message = "Name may not be empty or null")
   private String cpf;
   private String cnpj;
   private String email;
   private String telefone;
   
   @OneToOne(cascade = CascadeType.ALL)
   private AddressEntity addressEntity;

}
