package com.dev.cadastro.resources;

import java.util.ArrayList;
import java.util.List;

import com.dev.cadastro.models.Categoria;
import com.dev.cadastro.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
        List<Categoria> lista = categoriaRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}
    
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria categoria = categoriaRepository.findById(id).get();
		return ResponseEntity.ok().body(categoria);
	}

}
