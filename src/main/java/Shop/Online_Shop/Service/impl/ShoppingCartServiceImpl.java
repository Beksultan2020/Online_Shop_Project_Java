
package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.ShoppingCartService;
import Shop.Online_Shop.dto.ShoppingCartDto;
import Shop.Online_Shop.mapper.ShoppingCartMapper;
import Shop.Online_Shop.mapper.UserMapper;
import Shop.Online_Shop.model.Product;
import Shop.Online_Shop.model.Purchase;
import Shop.Online_Shop.model.ShoppingCart;
import Shop.Online_Shop.model.User;
import Shop.Online_Shop.repository.ProductRepository;
import Shop.Online_Shop.repository.PurchaseRepository;
import Shop.Online_Shop.repository.ShoppingCartRepository;
import Shop.Online_Shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private PurchaseRepository purchaseRepository;

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
            shoppingCart.setTotalPrice(0);
            shoppingCart.setProductList(new ArrayList<>());

        }

        List<Product> productList = shoppingCart.getProductList();
        boolean productAlreadyInCart = false;

        for (Product cartProduct : productList) {
            if (cartProduct.getId().equals(productId)) {
                cartProduct.setQuantity(cartProduct.getQuantity() + 1);
                productAlreadyInCart = true;
                break;
            }
        }

        if (!productAlreadyInCart) {
            product.setQuantity(1);
            productList.add(product);
        }

        shoppingCart.setProductList(productList);
        shoppingCartRepository.save(shoppingCart);
    }


    @Override
    public void deleteProductInShoppingCart(Long productId, Long shoppingCartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(shoppingCartId).orElseThrow();

        List<Product> productList = shoppingCart.getProductList();
        productList.removeIf(product -> product.getId().equals(productId));

        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public String checkout(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserIsCartId(userId);

        double totalPrice = calculateTotalPrice(shoppingCart);

        if (user.getBalance() >= totalPrice) {
            Purchase purchase = new Purchase();
            purchase.setUser(user);

            List<Product> productsToPurchase = new ArrayList<>(shoppingCart.getProductList());
            purchase.setProducts(productsToPurchase);

            purchase.setPurchaseTime(LocalDateTime.now());
            purchase.setTotalPrice(totalPrice);

            purchaseRepository.save(purchase);

            user.setBalance(user.getBalance() - totalPrice);
            userRepository.save(user);

            shoppingCart.getProductList().clear();
            shoppingCart.setTotalPrice(0);
            shoppingCartRepository.save(shoppingCart);

            return "Покупка успешно совершена!";
        } else {
            double requiredAmount = totalPrice - user.getBalance();
            return "Недостаточно средств для покупки! Вам не хватает " + requiredAmount + "KZT" + " денег";
        }
    }


    private double calculateTotalPrice(ShoppingCart shoppingCart) {
        double totalPrice = 0;
        List<Product> productList = shoppingCart.getProductList();
        for (Product product : productList) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    @Override
    public void createShoppingCartForUser(User user) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserIsCart(user);
        shoppingCart.setTotalPrice(0);
        shoppingCart.setProductList(new ArrayList<>());

        shoppingCartRepository.save(shoppingCart);
    }
}
