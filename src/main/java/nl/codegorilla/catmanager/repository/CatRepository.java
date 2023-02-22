package nl.codegorilla.catmanager.repository;

import nl.codegorilla.catmanager.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatRepository extends JpaRepository<Cat, Long> {
    void deleteCatById(Long id);

    Optional<Cat> findCatById(Long id);

}
