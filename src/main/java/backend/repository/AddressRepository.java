package backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.entity.AddressEntity;

/**
 *
 * @author mohamad
 */

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    
}
