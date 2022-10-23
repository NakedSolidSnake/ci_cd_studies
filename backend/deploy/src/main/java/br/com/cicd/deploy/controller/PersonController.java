package br.com.cicd.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cicd.deploy.domain.Person;
import br.com.cicd.deploy.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public Iterable<Person> onGet () {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> onGetById (@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Person onPost (@RequestBody Person person) {
        return service.insert (person);
    }

    @DeleteMapping("/{id}")
    public void onDelete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Person onPut (@PathVariable Long id, @RequestBody Person person) {
       return service.update(id, person);
    }
}
