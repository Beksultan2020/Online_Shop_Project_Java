package Shop.Online_Shop.api;

import Shop.Online_Shop.Service.impl.ShoppingCartServiceImpl;
import Shop.Online_Shop.dto.ShoppingCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartAPI {

    @Autowired
    private ShoppingCartServiceImpl shoppingCartServiceImpl;

    @GetMapping
    public List<ShoppingCartDto> getAllShoppingCartDto(){
        return shoppingCartServiceImpl.getAllShoppingCartDto();
    }
    @GetMapping("{id}")
    public ShoppingCartDto getShoppingCartDto(@PathVariable(value = "id")Long id){
        return  shoppingCartServiceImpl.getShoppingCartDto(id);
    }
    @GetMapping("/checkout/{userId}")
    public String checkout(@PathVariable(value = "userId")Long userId){
        return shoppingCartServiceImpl.checkout(userId);
    }

    @PostMapping("/addProduct/{productId}/{userId}")
    public void addProductInShoppingCard(@PathVariable(value = "productId")Long productId, @PathVariable(value = "userId") Long userId){
        shoppingCartServiceImpl.addProductInShoppingCard(productId,userId);
    }

    @DeleteMapping ("/deleteProductInShoppingCart/{productId}/{shoppingCartId}")
    public void deleteProductInShoppingCart(@PathVariable(value = "productId") Long productId, @PathVariable(value = "shoppingCartId") Long shoppingCartId){
        shoppingCartServiceImpl.deleteProductInShoppingCart(productId, shoppingCartId);
    }
}
