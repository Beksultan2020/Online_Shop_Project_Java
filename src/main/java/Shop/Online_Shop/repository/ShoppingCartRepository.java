package Shop.Online_Shop.repository;

import Shop.Online_Shop.modеl.ShoppingCart;
import Shop.Online_Shop.modеl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByUserIsCartId(Long userId);
}
