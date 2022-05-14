package backend.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import backend.repository.PersonRepository;

/**
 *  
 * @author mohamad
 */

class PersonEntityTest {
	
	
	/* ==================== Setting the scene ==================== */
	 // Creating a client	
	PersonEntity personEntity = new PersonEntity(
			(long) 1, "Mohamad Montalbo", "999999999", null, "said2288@hotmail.com", "983999224", true, null);    	

	
	/* ======================== Execution ======================== */
	@Test
	void testGetId() {
		
		/* ==================== Verification ==================== */
		assertEquals(personEntity.getId(), 1);
	}
	
	@Test
	void testGetNome() {
		
		/* ==================== Verification ==================== */
		assertEquals(personEntity.getNome(), "Mohamad Montalbo");
	}

	@Test
	void testGetCpf() {
		
		/* ==================== Verification ==================== */
		assertEquals(personEntity.getCpf(), "999999999");
	}

	@Test
	void testGetCnpj() {
		
		/* ==================== Verification ==================== */
		assertNull(personEntity.getCnpj());
	}

	@Test
	void testGetEmail() {
		
		/* ==================== Verification ==================== */
		assertEquals(personEntity.getEmail(), "said2288@hotmail.com");
	}

	@Test
	void testGetTelefone() {
		
		/* ==================== Verification ==================== */
		assertEquals(personEntity.getTelefone(), "983999224");
	}

	@Test
	void testIsAtivo() {
		
		/* ==================== Verification ==================== */
		assertTrue(personEntity.isAtivo());
	}
	
	@Test
	void testAddressEntity() {
		
		/* ==================== Verification ==================== */
		assertNull(personEntity.getAddressEntity());
	}

}
