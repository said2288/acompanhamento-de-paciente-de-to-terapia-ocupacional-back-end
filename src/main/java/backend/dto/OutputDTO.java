package backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author mohamad
 */

@AllArgsConstructor
@Data
public class OutputDTO {
    
    private Long id;   
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;
    private String telefone;
   
//    public static OutputDTO transformInDTO(PersonEntity personEntity) {
//        return new OutputDTO(personEntity.getId(), personEntity.getNome(),
//                personEntity.getCpf(), personEntity.getCnpj()
//                personEntity.getEmail(), personEntity.getTelefone());
//    }
}
