package backend.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import backend.entity.PersonEntity;
import backend.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
	
	@Mock
    private PersonRepository personRepository;
	
	@InjectMocks
	private ClientService clientService;
	
	/* ==================== Setting the scene ==================== */
	// Creating a list of client
	List<PersonEntity> testList = new ArrayList<PersonEntity>();
	// Creating customers 
	PersonEntity personEntity0 = new PersonEntity(
			(long) 1, "Mohamad Montalbo", "777777777", null, "said2288@hotmail.com", "983999224", true, null);
	PersonEntity personEntity1 = new PersonEntity(
			(long) 2, "Aaid Montalbo", "888888888", null, "montalbo005@gmail.com", "983999224", true, null);
	
	// Customer with Optional
	Optional<PersonEntity> personEntityOptional = Optional.ofNullable(new PersonEntity(
					(long) 1, "Mohamad Montalbo", "999999999", null, "said2288@hotmail.com", "983999224", true, null));
	
	/* ======================== Execution ======================== */
	@Test
	void testListAllCustomers() {
		
		// Add customers to a list
		testList.add(personEntity0);
		testList.add(personEntity1);
		
		/* ==================== Verification ==================== */
		given(personRepository.findAllByOrderByNomeAsc()).willReturn(testList);

		List customerList = clientService.listAllCustomers();
		
		assertNotNull(customerList);
		assertThat(customerList.size()).isEqualTo(2);
	}

	@Test
	void testListCustomer() {
		
		// Creating variable for id control
		long id = 1;

		/* ==================== Verification ==================== */
		given(personRepository.findById(id)).willReturn(personEntityOptional);

		Optional<PersonEntity> personIdFindOrNot = clientService.listCustomer(id);
		
		assertNotNull(personIdFindOrNot);
	}

	@Test
	void testSearchCpf() {
		
		// Cpf of client created in the Setting the scene
		// 999999999
		// Creating variable for cpf control
		String cpf = "999999999";
		
		/* ==================== Verification ==================== */
		given(personRepository.findByCpf(cpf)).willReturn(personEntity0);
		
		PersonEntity personCpf = clientService.searchCpf(cpf);
		
		assertThat(personCpf.equals(personEntity0));
	}

	@Test
	void testCreationFromCustomer() {
		
		/* ==================== Verification ==================== */
		given(personRepository.save(personEntity0)).willReturn(personEntity0);
		
		PersonEntity responsePerson = clientService.creationFromCustomer(personEntity0);

		assertNotNull(responsePerson);
	}

	@Test
	void testEditData() {
		
		// Creating variable for id control
		long id = 1;
		
		// Fields update only in "nome" and "email". 
		personEntity0.setNome("Montalbo");
		personEntity0.setEmail("montalbo@gmail.com");

		/* ==================== Verification ==================== */
		given(personRepository.findById(id)).willReturn(personEntityOptional);
		given(personRepository.save(personEntity0)).willReturn(personEntity0);

		Optional<PersonEntity> gettingUpdatedCustomer = clientService.editData(id, personEntity0);
		
		assertEquals(gettingUpdatedCustomer.get().getNome(), "Montalbo");
		assertEquals(gettingUpdatedCustomer.get().getEmail(), "montalbo@gmail.com");
	}

}
