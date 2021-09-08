package backend.repository;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import backend.entity.PersonEntity;

/**
 *
 * @author mohamad
 */

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    public PersonEntity findById(Id id);
    public PersonEntity findByCpf(String cpf);
    public List<PersonEntity> findAllByOrderByNomeAsc();
}
