
package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.ShoppingCartService;
import Shop.Online_Shop.dto.ShoppingCartDto;
import Shop.Online_Shop.mapper.ShoppingCartMapper;
import Shop.Online_Shop.mapper.UserMapper;
import Shop.Online_Shop.model.Product;
import Shop.Online_Shop.model.ShoppingCart;
import Shop.Online_Shop.model.User;
import Shop.Online_Shop.repository.ProductRepository;
import Shop.Online_Shop.repository.ShoppingCartRepository;
import Shop.Online_Shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<ShoppingCartDto> getAllShoppingCartDto() {
        List<ShoppingCart> shoppingCartList = shoppingCartRepository.findAll();
        return shoppingCartMapper.shoppingCartListToDto(shoppingCartList);
    }

    @Override
    public ShoppingCartDto getShoppingCartDto(Long id) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(id).orElseThrow();
        return shoppingCartMapper.shoppingCartToDto(shoppingCart);
    }

    @Override
    public void addProductInShoppingCard(Long productId, Long userId) {

        Product product = productRepository.findById(productId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        ShoppingCart shoppingCart = shoppingCartRepository.findByUserIsCartId(userId);

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserIsCart(user);
            shoppingCart.setProductList(new ArrayList<>());

        }
        List<Product> productList = shoppingCart.getProductList();
        productList.add(product);
        shoppingCart.setProductList(productList);
        ShoppingCart shoppingCart1 = new ShoppingCart();
        shoppingCartRepository.save(shoppingCart);
    }


    @Override
    public void deleteProduct(Long productId, Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow();

        List<Product> productList = shoppingCart.getProductList();
        Iterator<Product> iterator = productList.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(productId)) {
                iterator.remove();
            }
        }
        shoppingCart.setProductList(productList);

        shoppingCartRepository.save(shoppingCart);

    }


    @Override
    public double totalPrice(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserIsCartId(userId);

        double totalPrice = 0;
        List<Product> productList = shoppingCart.getProductList();
        for (Product product : productList) {
            totalPrice += product.getPrice();
        }
        shoppingCart.setTotalPrice(totalPrice);

        shoppingCartRepository.save(shoppingCart);
        return totalPrice;
    }


    @Override
    public void delCounter(Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow();
        int counter = shoppingCart.getCounter();
        if (counter > 0) {
            shoppingCart.setCounter(counter - 1);
            shoppingCartRepository.save(shoppingCart);
        }
    }

    @Override
    public void addCounter(Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow();

        int counter = shoppingCart.getCounter();
        shoppingCart.setCounter(counter + 1);

        shoppingCartRepository.save(shoppingCart);
    }

}
