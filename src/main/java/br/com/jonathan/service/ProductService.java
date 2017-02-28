package br.com.jonathan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jonathan.model.Product;
import br.com.jonathan.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findOne(Long id) {
		return repository.findOne(id);
	}

	public Product save(Product product) {
		return repository.saveAndFlush(product);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}