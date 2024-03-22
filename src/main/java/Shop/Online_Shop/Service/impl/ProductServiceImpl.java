package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.ProductService;

import Shop.Online_Shop.modеl.Product;
import Shop.Online_Shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)){
            product.setId(id);
            return productRepository.save(product);
        }
        else {
            throw new RuntimeException("Такого продукта не существует по данному id: "+id);
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
