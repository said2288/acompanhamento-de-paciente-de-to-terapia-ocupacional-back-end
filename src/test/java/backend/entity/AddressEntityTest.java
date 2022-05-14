package backend.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 *  
 * @author mohamad
 */

class AddressEntityTest {
	
	
	/* ==================== Setting the scene ==================== */
	 // Creating a client
	AddressEntity addressEntity = new AddressEntity(
			(long) 1, "SP", "Campinas", "13034541", "Centro", "Rua Campos Salles", "200");
    
	/* ======================== Execution ======================== */
	@Test
	void testGetId() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getId(), 1);
	}

	@Test
	void testGetUf() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getUf(), "SP");
	}

	@Test
	void testGetCidade() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getCidade(), "Campinas");
	}

	@Test
	void testGetCep() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getCep(), "13034541");
	}

	@Test
	void testGetBairro() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getBairro(), "Centro");
	}

	@Test
	void testGetEndereco() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getEndereco(), "Rua Campos Salles");
	}

	@Test
	void testGetNumero() {
		
		/* ==================== Verification ==================== */
		assertEquals(addressEntity.getNumero(), "200");
	}

}
