package backend.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import backend.service.ClientService;
import backend.entity.PersonEntity;

/**
 *
 * @author mohamad
 */

@RestController
@RequestMapping("/cliente")
public class ClientController {
    
    private final ClientService clientService;
    
    ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity listAllCustomers() {
        
        if(clientService.listAllCustomers().isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(clientService.listAllCustomers(), HttpStatus.OK);
        }
        
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = {"/{id}"})
    public ResponseEntity listCustomer(@PathVariable long id) {
                      
        if(clientService.listCustomer(id).isPresent()) {
            return new ResponseEntity(clientService.listCustomer(id), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping(path = {"cpf/{cpf}"})
    public ResponseEntity searchCpf(@PathVariable String cpf) {
        
        PersonEntity cpfClient = clientService.searchCpf(cpf);
        PersonEntity CPFvalidated = null;
              
            try {
                if(cpfClient.getCpf() != null) {
                    CPFvalidated = cpfClient;    
            }             
                
            } catch (NullPointerException e) {
                  return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            
          return new ResponseEntity(CPFvalidated, HttpStatus.OK); 
                
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity creationFromCustomer(@RequestBody PersonEntity personEntity) {
        
        PersonEntity client = clientService.creationFromCustomer(personEntity);
        return new ResponseEntity(personEntity, HttpStatus.OK);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(path = {"/{id}"})
    public ResponseEntity editData(@PathVariable long id,
                                      @RequestBody PersonEntity personEntity) {
        
        Optional<PersonEntity> client = clientService.editData(id, personEntity);
        
        if(client.isPresent()) {
            return new ResponseEntity(client, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
    }

}


