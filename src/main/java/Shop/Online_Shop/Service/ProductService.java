package Shop.Online_Shop.Service;

import Shop.Online_Shop.modеl.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> searchProductByName(String name);

    Product addProduct(Product product);

    Product updateProduct(Long id,Product product);
    void deleteProduct(Long id);

}
