package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.ShoppingCartService;
import Shop.Online_Shop.modеl.Product;
import Shop.Online_Shop.modеl.ShoppingCart;
import Shop.Online_Shop.modеl.User;
import Shop.Online_Shop.repository.ProductRepository;
import Shop.Online_Shop.repository.ShoppingCartRepository;
import Shop.Online_Shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override
    public void addProductInShoppingCard(Long productId, Long userId) {
        productRepository.findById(productId).orElseThrow();

        User user=userRepository.findById(userId).orElseThrow();

        ShoppingCart shoppingCart=shoppingCartRepository.findByUserIsCartId(userId);

        if (shoppingCart==null){
            shoppingCart=new ShoppingCart();
            shoppingCart.setUserIsCart(user);
        }
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
