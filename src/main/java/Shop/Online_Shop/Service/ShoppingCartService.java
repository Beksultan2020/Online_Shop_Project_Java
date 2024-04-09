
package Shop.Online_Shop.Service;

import Shop.Online_Shop.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getAllShoppingCart();
    ShoppingCart getShoppingCart(Long id);
    void addProductInShoppingCard(Long productId,Long userId);
    void deleteProduct(Long productId,Long shoppingCartId);
    double totalPrice(Long userId);
    void delCounter(Long shoppingCartId);
    void addCounter(Long shoppingCartId);

}
