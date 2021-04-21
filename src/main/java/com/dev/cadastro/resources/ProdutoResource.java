package com.dev.cadastro.resources;

import java.util.ArrayList;
import java.util.List;

import com.dev.cadastro.models.Produto;
import com.dev.cadastro.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping
	public ResponseEntity<List<Produto>> findAll() {
        List<Produto> lista = produtoRepository.findAll();
		return ResponseEntity.ok().body(lista);
	}
    
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto produto = produtoRepository.findById(id).get();
		return ResponseEntity.ok().body(produto);
	}

}
