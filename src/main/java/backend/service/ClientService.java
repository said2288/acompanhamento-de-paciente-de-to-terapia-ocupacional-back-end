package backend.service;

import java.util.stream.Collectors;
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
        
        List<PersonEntity> personActive = personRepository.findAll();
        
        return personActive.stream()
                .filter(pA -> pA.isAtivo())
                .collect(Collectors.toList());
    }
    
    public Optional<PersonEntity> listCustomer(long id) {
        
        Optional<PersonEntity> dataCustomer = personRepository.findById(id)
                .filter(l -> l.isAtivo());
        
        if(dataCustomer.isPresent()) {
            return personRepository.findById(id);
        } else {
            return Optional.empty();
        }
         
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
    
    public Optional<PersonEntity> editData(long id, PersonEntity personEntity) {
        return personRepository.findById(id)
            .map(record -> {
                record.setNome(personEntity.getNome());
                record.setCpf(personEntity.getCpf());
                record.setCnpj(personEntity.getCnpj());
                record.setEmail(personEntity.getEmail());
                record.setTelefone(personEntity.getTelefone());
                record.setAtivo(personEntity.isAtivo());
                record.setAddressEntity(personEntity.getAddressEntity());

                PersonEntity updateClient = personRepository.save(record);

                return updateClient;
            });
    }
}