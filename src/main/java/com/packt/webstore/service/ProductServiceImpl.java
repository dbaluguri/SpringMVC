package com.packt.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packt.webstore.dao.ProductDAO;
import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	public List<Product> getProductsByCategory(String category) {
		return productDAO.getProductsByCategory(category);
	}
	
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productDAO.getProductsByFilter(filterParams);
	}

	public Product getProductById(String productId) {
		return productDAO.getProductById(productId);
	}

	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}
	
	

}
