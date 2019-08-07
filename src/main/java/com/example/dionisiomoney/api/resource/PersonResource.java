package com.example.dionisiomoney.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.dionisiomoney.api.model.Person;
import com.example.dionisiomoney.api.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonResource {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Person> save(@Valid @RequestBody Person person, HttpServletResponse response) {
		Person savedPerson = personRepository.save(person); 
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedPerson.getId()).toUri();
		return ResponseEntity.created(uri).body(savedPerson);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Optional<Person> personOptional = personRepository.findById(id);
		
		return personOptional.isPresent() ? ResponseEntity.ok(personOptional.get()) : ResponseEntity.notFound().build();
	}
	
}
