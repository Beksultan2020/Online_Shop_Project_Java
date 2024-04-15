package Shop.Online_Shop.dto;


import Shop.Online_Shop.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {
    private int counter;
    private double totalPrice;
    private List<Product> productList;
    private UserDto userIsCart;
}
