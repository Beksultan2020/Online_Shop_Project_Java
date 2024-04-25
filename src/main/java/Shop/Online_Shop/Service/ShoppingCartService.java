
package Shop.Online_Shop.Service;

import Shop.Online_Shop.dto.ShoppingCartDto;
import Shop.Online_Shop.model.ShoppingCart;
import Shop.Online_Shop.model.User;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCartDto> getAllShoppingCartDto();
    ShoppingCartDto getShoppingCartDto(Long id);
    void addProductInShoppingCard(Long productId,Long userId);
    void deleteProductInShoppingCart(Long productId,Long shoppingCartId);
    String checkout(Long userId);
    void createShoppingCartForUser(User user);

}
