package backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import backend.entity.PersonEntity;
import backend.repository.PersonRepository;

/**
 *
 * @author mohamad
 */

@Service
public class ClientService {
    
   private final PersonRepository personRepository;
   
    ClientService(PersonRepository personRepository) {
       this.personRepository = personRepository;
    }
    
    public List listAllCustomers() { 
        return personRepository.findAll();
    }
    
    public Optional<PersonEntity> listCustomer(long id) { 
        return personRepository.findById(id);
    }
    
    public PersonEntity searchCpf(String cpfClient) {
        
        PersonEntity client = null;
        
            try {
                
                client = personRepository.findByCpf(cpfClient);
            
                if(client.getCpf() != null) {     
                    
                    return client;
                }

                
            } catch (NullPointerException e) {
                
                System.out.println("CPF inválido");
                
            }
                
        return client;
    }
    
    public PersonEntity creationFromCustomer(PersonEntity personEntity) { 
        return personRepository.save(personEntity);
    }
    
    public Optional<PersonEntity> editDataPerson(long id, PersonEntity personEntity) {
        return personRepository.findById(id)
            .map(record -> {
                record.setNome(personEntity.getNome());
                record.setEmail(personEntity.getEmail());
                record.setTelefone(personEntity.getTelefone());
                record.setCpf(personEntity.getCpf());
                record.setCnpj(personEntity.getCnpj());

                PersonEntity updateClient = personRepository.save(record);

                return updateClient;
            });
    }
}