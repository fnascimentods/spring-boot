package com.dev.cadastro;

import java.util.Arrays;

import com.dev.cadastro.models.Categoria;
import com.dev.cadastro.models.Produto;
import com.dev.cadastro.repositories.CategoriaRepository;
import com.dev.cadastro.repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroApplication implements CommandLineRunner{
	
	@Autowired
    private CategoriaRepository categoriaRepository;

	@Autowired
    private ProdutoRepository produtoRepository;	

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
	
		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);
	
		Produto p1 = new Produto(null, "TV", 2200.00, cat1);
		Produto p2 = new Produto(null, "Domain Driven Design", 120.00, cat2);
		Produto p3 = new Produto(null, "PS5", 2800.00, cat1);
		Produto p4 = new Produto(null, "Docker", 100.00, cat2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		produtoRepository.save(p4);
	}

}
