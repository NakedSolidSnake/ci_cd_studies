package br.com.cicd.deploy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cicd.deploy.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{    
}
