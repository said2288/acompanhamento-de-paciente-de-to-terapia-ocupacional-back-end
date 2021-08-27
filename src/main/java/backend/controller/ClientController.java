package backend.controller;

import java.util.List;
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
import backend.dto.InputDTO;
import backend.dto.OutputDTO;

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
    public List listAllCustomers() {
        return clientService.listAllCustomers();
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = {"/{id}"})
    public Optional<PersonEntity> listCustomer(@PathVariable long id) {
        return clientService.listCustomer(id);
    }
    
    @GetMapping(path = {"cpf/{cpf}"})
    public ResponseEntity<PersonEntity> searchCpf(@PathVariable String cpf) {
        
        PersonEntity cpfClient = clientService.searchCpf(cpf);
              
            try {
                
            if(cpfClient.getCpf() != null) {
                
                return new ResponseEntity<PersonEntity>(cpfClient, HttpStatus.OK);
                
            } 
            
            } catch (NullPointerException e) {
                
                System.out.println("Retorno tratado para o cliente");
            }
            
        return new ResponseEntity<PersonEntity>(HttpStatus.NOT_FOUND);
            
    }
    
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PostMapping
//    public ResponseEntity<OutputDTO> creationFromCustomer(@RequestBody InputDTO inputDTO) {
//        PersonEntity client = clientService.creationFromCustomer(inputDTO.transformToClient());
//        return new ResponseEntity(OutputDTO.transformInDTO(client), HttpStatus.CREATED);
//    }
    
//    @CrossOrigin(origins = "http://localhost:4200")
//    @PutMapping("{id}")
//    public ResponseEntity<InputDTO> editCustomer(@PathVariable("id") long id,
//                                      @RequestBody InputDTO inputDTO) {
//        Optional<PersonEntity> client = clientService.editDataPerson(id, inputDTO.transformToClient());
//        return new ResponseEntity(client, HttpStatus.CREATED);
//    }

}


