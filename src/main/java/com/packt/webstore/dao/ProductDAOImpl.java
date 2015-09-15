package com.packt.webstore.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public Product getProductById(String productId) {
		Session session = getSession();
		
		Product product = (Product)session.get(Product.class, productId);
		
		/*
		Product productById = null;
		for (Product product : listOfProducts) {
			if (product != null && product.getProductId() != null && product.getProductId().equals(productId)) {
				productById = product;
				break;
			}
		} */
		if (product == null) {
			throw new IllegalArgumentException("No products found with the product id: " + productId);
		}
		return product;
	}

	public List<Product> getAllProducts() {
		Session session = getSession();
		Query query = session.createQuery("from Product");

		return query.list();
	}

	public List<Product> getProductsByCategory(String category) {
		/*List<Product> productsByCategory = new ArrayList<Product>();
		for (Product product : listOfProducts) {
			if (category.equalsIgnoreCase(product.getCategory())) {
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
		*/
		return null;
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		/*Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		if (criterias.contains("brand")) {
			for (String brandName : filterParams.get("brand")) {
				for (Product product : listOfProducts) {
					if (brandName.equalsIgnoreCase(product.getManufacturer())) {
						productsByBrand.add(product);
					}
				}
			}
		}
		if (criterias.contains("category")) {
			for (String category : filterParams.get("category")) {
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
		*/
		return null;
	}

	public void addProduct(Product product) {
		Session session = getSession();

		try {
			session.save(product);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		}
	}
}
