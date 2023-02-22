package nl.codegorilla.catmanager;

import nl.codegorilla.catmanager.model.Cat;
import nl.codegorilla.catmanager.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {
        "http://localhost:4200"
})
@RequestMapping("/cat")
public class CatController {


    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cat>> getAllCats() {
        List<Cat> cats = catService.findAllCats();
        return new ResponseEntity<>(cats, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable("id") Long id) {
        Cat cat = catService.findCatById(id);
        return new ResponseEntity<>(cat, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat) {
        Cat newCat = catService.addCat(cat);
        return new ResponseEntity<Cat>(newCat, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Cat> updateCat(@RequestBody Cat cat) {
        Cat updateCat = catService.updateCat(cat);
        return new ResponseEntity<>(updateCat, HttpStatus.OK);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteCat(@PathVariable("id") Long id) {
        catService.deleteCat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
