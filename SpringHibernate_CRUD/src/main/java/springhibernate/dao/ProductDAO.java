package springhibernate.dao;

import java.util.List;

import springhibernate.entities.Product;

public interface ProductDAO {
	public List<Product> getProducts();
	public boolean insertProduct(Product p);
	public Product getProductById(Integer proId);
	public boolean updateProduct(Product p);
	public boolean deleteProduct(Integer proId);
	public List<Product> getProductsByName(String proName);
}
