package Shop.Online_Shop.mapper;


import Shop.Online_Shop.dto.ShoppingCartDto;
import Shop.Online_Shop.model.ShoppingCart;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartMapper {
    ShoppingCartDto shoppingCartToDto(ShoppingCart shoppingCart);

    ShoppingCart shoppingCartToEntity(ShoppingCartDto shoppingCartDto);

    List<ShoppingCartDto> shoppingCartListToDto(List<ShoppingCart> shoppingCarts);

    List<ShoppingCart> shoppingCartListToEntity(List<ShoppingCartDto> shoppingCartDtos);
}
