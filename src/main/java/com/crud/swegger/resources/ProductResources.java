package com.crud.swegger.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.swegger.models.Product;
import com.crud.swegger.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProductResources {
	
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Product> listProducts(){
		return productRepository.findAll();
	}
	@GetMapping("/product{id}")
	@ApiOperation(value = "Retorna uma produto unico")
	public Product listProductsunico(@PathVariable(value = "id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value = "Salva um produto")
	public Product salvaProducts(@RequestBody Product produto){
		return productRepository.save(produto);
	}
	@DeleteMapping("/product")
	@ApiOperation(value = "Deleta um produto")
	public void deleteProducts(@RequestBody Product produto){
		productRepository.delete(produto);
	}
	@PutMapping("/product")
	@ApiOperation(value = "Atualiza um produto")
	public Product atualizeProducts(@RequestBody Product produto){
		return productRepository.save(produto);
	}
}
