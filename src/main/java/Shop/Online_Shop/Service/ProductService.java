package Shop.Online_Shop.Service;

import Shop.Online_Shop.modеl.Product;
import Shop.Online_Shop.modеl.Type;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    List<Product> searchProductByName(String name);

    List<Product> sortedPriceByAcs();

    List<Product> sortedPriceByDesc();

    List<Product> sortedNameByAcs();

    List<Product> sortedNameByDesc();

    List<Product> getAllProductsByType(Long typeId);

    Product addProduct(Product product);

    Product updateProduct(Long id, Product product);

    double countMark();

    String conversionToRating();

    void deleteProduct(Long id);

}
