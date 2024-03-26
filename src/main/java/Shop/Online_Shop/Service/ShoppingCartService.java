package Shop.Online_Shop.Service;

import Shop.Online_Shop.modеl.Product;

import java.util.List;

public interface ShoppingCartService {
    List<Product> getAllProducts();
    Product getProduct(Long id);
    void addProductInShoppingCard(Long productId,Long userId);
    void deleteProduct(Long id);

}
