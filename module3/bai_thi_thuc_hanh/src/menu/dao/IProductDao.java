package menu.dao;

import menu.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDao {
    public List<Product> selectAllProduct();
    public Product getProductById(int id);
    public void deleteProduct(int id) throws SQLException;
    public void insertProduct(Product product);
    public void updateProduct(Product product) throws SQLException;
}
