package menu.bo;

import menu.dao.IProductDao;
import menu.dao.ProductDao;
import menu.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductBo implements IProductBo {
    IProductDao iProductDao = new ProductDao();

    @Override
    public List<Product> selectAllProduct() {
        return iProductDao.selectAllProduct();
    }

    @Override
    public Product getProductById(int id) {
        return iProductDao.getProductById(id);
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        iProductDao.deleteProduct(id);
    }

    @Override
    public void insertProduct(Product product) {
        iProductDao.insertProduct(product);
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        iProductDao.insertProduct(product);
    }
}
