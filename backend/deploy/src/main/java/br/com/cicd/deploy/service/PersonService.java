package br.com.cicd.deploy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cicd.deploy.domain.Person;
import br.com.cicd.deploy.repository.PersonRepository;

@Service
public class PersonService {
    
    @Autowired
    private PersonRepository repository;

    public Iterable<Person> getAll () {
        return repository.findAll();
    }

    public ResponseEntity<?> getById (Long id) {
        Optional<Person> person = repository.findById(id);
        if (person.isPresent()) {
            return new ResponseEntity<Person>(person.get(), HttpStatus.OK);
        }

        return new ResponseEntity<String>("Not Found", HttpStatus.BAD_REQUEST);
    }

    public Person insert(Person person) {
        return repository.save(person);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Person update(Long id, Person person) {
        person.setId(id);
        return repository.save(person);
    }
}
