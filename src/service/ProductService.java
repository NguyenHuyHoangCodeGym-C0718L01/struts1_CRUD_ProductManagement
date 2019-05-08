package service;

/*import java.sql.ResultSet;*/
import java.sql.SQLException;
/*import java.util.ArrayList;*/
import java.util.List;

import model.ProductDB;
import repository.*;
public class ProductService {

	private ProductRepository productRepository;
	
	public ProductService(){
		productRepository = new ProductRepository();
	}

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public int saveProduct(ProductDB product){
		try{
			return productRepository.registerProduct(product);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public int deleteProduct(int id){
		try{
			return productRepository.deleteProduct(id);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public int updateProduct(ProductDB product){
		try{
			return productRepository.updateProduct(product);
		}catch(Exception ex){
			return -1;
		}
	}
	
	public ProductDB getProductById(int id) throws SQLException, Exception{
		return productRepository.getProductById(id);
	}
	
	public List<ProductDB> getListProducts() throws SQLException, Exception{
		return productRepository.getAllProducts();
	}
}
