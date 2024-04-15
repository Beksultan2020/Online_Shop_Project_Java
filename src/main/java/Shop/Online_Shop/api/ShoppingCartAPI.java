package Shop.Online_Shop.api;

import Shop.Online_Shop.Service.impl.ShoppingCartServiceImpl;
import Shop.Online_Shop.dto.ShoppingCartDto;
import Shop.Online_Shop.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartAPI {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartServiceImpl;

    @GetMapping
    public List<ShoppingCartDto> getAllProducts(){
        return shoppingCartServiceImpl.getAllShoppingCartDto();
    }
    @GetMapping("{id}")
    public ShoppingCartDto getShoppingCartDto(@PathVariable(value = "id")Long id){
        return  shoppingCartServiceImpl.getShoppingCartDto(id);
    }
    @PostMapping("/addProduct/{productId}/{userId}")
    public void addProduct(@PathVariable(value = "productId")Long productId, @PathVariable(value = "userId") Long userId){
        shoppingCartServiceImpl.addProductInShoppingCard(productId,userId);
    }

    @DeleteMapping ("/deleteProductInShoppingCart   /{productId}/{userId}")
    public void deleteProductInShoppingCart(@PathVariable(value = "productId") Long productId, @PathVariable(value = "userId") Long shoppingCartId){
        shoppingCartServiceImpl.deleteProduct(productId, shoppingCartId);
    }

    @GetMapping("/totalPrice/{id}")
    public double totalPrice(@PathVariable(value = "id") Long userId){
        return shoppingCartServiceImpl.totalPrice(userId);
    }

    @PutMapping("delCounter/{id}")
    public void delCounter(@PathVariable(value = "id") Long shoppingCartId){
        shoppingCartServiceImpl.delCounter(shoppingCartId);
    }

    @PutMapping("addCounter/{id}")
    public void addCounter(@PathVariable(value = "id") Long shoppingCartId){
        shoppingCartServiceImpl.delCounter(shoppingCartId);
    }
}
