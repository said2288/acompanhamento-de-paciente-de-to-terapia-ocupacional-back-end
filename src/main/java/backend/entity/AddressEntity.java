package backend.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mohamad
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="address")
public class AddressEntity {
    
   @Id 
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
    
   private String uf;
   private String cidade;
   private String cep;
   private String bairro;
   private String endereco;
   private String numero;
   
}
