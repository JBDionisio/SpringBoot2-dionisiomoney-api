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

import com.example.dionisiomoney.api.model.Category;
import com.example.dionisiomoney.api.repository.CategoryRepository;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public List<Category> listAll() {
		return categoryRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Category> save(@Valid @RequestBody Category category, HttpServletResponse response) {
		Category savedCategory = categoryRepository.save(category);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(savedCategory.getId()).toUri();
		
		return ResponseEntity.created(uri).body(savedCategory);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		
		return categoryOptional.isPresent() ? ResponseEntity.ok(categoryOptional.get()) : ResponseEntity.notFound().build();
	}
	
}
