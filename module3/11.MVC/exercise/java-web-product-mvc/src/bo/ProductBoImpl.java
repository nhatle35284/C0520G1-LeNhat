package bo;

import dao.ProductDaoImpl;
import model.Product;

import java.util.List;

public class ProductBoImpl implements ProductBO {
    private ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    public List<Product> getListProduct() {
        return productDao.getListProduct();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productDao.findByName(name);
    }
}
