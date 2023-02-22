package nl.codegorilla.catmanager.service;

import jakarta.transaction.Transactional;
import nl.codegorilla.catmanager.exception.CatNotFoundException;
import nl.codegorilla.catmanager.model.Cat;
import nl.codegorilla.catmanager.repository.CatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatService {
    private final CatRepository catRepository;


    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public Cat addCat(Cat cat) {
        return catRepository.save(cat);
    }

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public Cat updateCat(Cat cat) {
        return catRepository.save(cat);
    }

    public Cat findCatById(Long id) {
        return catRepository.findCatById(id)
                .orElseThrow(() -> new CatNotFoundException("Cat by id: " + id + " not found"));
    }
    @Transactional
    public void deleteCat(Long id) {
        catRepository.deleteCatById(id);
    }
}
