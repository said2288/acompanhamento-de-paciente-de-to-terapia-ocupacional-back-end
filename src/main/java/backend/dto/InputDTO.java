package backend.dto;

import lombok.Data;

/**
 *
 * @author mohamad
 */

@Data
public class InputDTO {
    
    private String id;
    private String nome;
    private String cpf;
    private String cnpj;
    private String email;
    private String telefone;
   
//    public PersonEntity transformToClient() {
//        return new PersonEntity(nome, cpf, cnpj, email, telefone);
//    }
    
}

