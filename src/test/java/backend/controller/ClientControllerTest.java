package backend.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import backend.entity.PersonEntity;
import backend.service.ClientService;

@WebMvcTest
class ClientControllerTest {
	
    @Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ClientService clientService;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	/* ==================== Setting the scene ==================== */
	// Creating a list of client
	List<PersonEntity> persons = new ArrayList<PersonEntity>();
	// Creating customer
	PersonEntity person = new PersonEntity(
			(long) 1, "Mohamad Montalbo", "777777777", null, "said2288@hotmail.com", "983999224", true, null);
	
	// Customer with Optional
	Optional<PersonEntity> personEntityOptional = Optional.ofNullable(new PersonEntity(
			(long) 1, "Montalbo", "999999999", null, "said2288@hotmail.com", "983999224", true, null));
	
	/* ======================== Execution ======================== */
	@Test
	void testListAllCustomers() throws Exception {
		
		// Add customer to a list
		persons.add(person);
		/* ==================== Verification ==================== */
		Mockito.when(clientService.listAllCustomers()).thenReturn(persons);
	    mockMvc.perform(get("/cliente"))
	    	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$", Matchers.hasSize(1)))
	    	.andExpect(jsonPath("$[0]", Matchers.hasEntry("nome", "Mohamad Montalbo")));
	}

	@Test
	void testListCustomer() throws Exception {
		
		// Creating variable for id control
		long id = 1;
		/* ==================== Verification ==================== */
		Mockito.when(clientService.listCustomer(id)).thenReturn(personEntityOptional);
	    mockMvc.perform(get("/cliente/{id}", id))
	    	.andExpect(status().isOk())    	
	    	.andExpect(jsonPath("$", Matchers.hasEntry("email", "said2288@hotmail.com")));
	}

	@Test
	void testSearchCpf() throws Exception {
		
		// Creating variable for cpf control
		String cpf = "777777777";
		/* ==================== Verification ==================== */
		Mockito.when(clientService.searchCpf(cpf)).thenReturn(person);
	    mockMvc.perform(get("/cliente/cpf/{cpf}", cpf))
	    	.andExpect(status().isOk())    	
	    	.andExpect(jsonPath("$", Matchers.hasEntry("cpf", "777777777")));
	}

	@Test
	void testCreationFromCustomer() throws Exception {
		
		/* ==================== Verification ==================== */
		Mockito.when(clientService.creationFromCustomer(person)).thenReturn(person);
		String json = mapper.writeValueAsString(person);
	    mockMvc.perform(post("/cliente")
	    		.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
	    		.characterEncoding("utf-8")
	            .content(json)
	            .accept(org.springframework.http.MediaType.APPLICATION_JSON))
	    	.andExpect(status().isOk())    	
	    	.andExpect(jsonPath("$", Matchers.hasEntry("cpf", "777777777")));

	}

	@Test
	void testEditData() throws Exception {
		
		// Creating variable for id control
		long id = 1;
		/* ==================== Verification ==================== */
		Mockito.when(clientService.editData(id, person)).thenReturn(personEntityOptional);
		String json = mapper.writeValueAsString(person);
	    mockMvc.perform(put("/cliente/{id}", id)
	    		.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
	    		.characterEncoding("utf-8")
	            .content(json)
	            .accept(org.springframework.http.MediaType.APPLICATION_JSON))
	    	.andExpect(status().isOk())    	
	    	.andExpect(jsonPath("$", Matchers.hasEntry("nome", "Montalbo")));
	}

}
