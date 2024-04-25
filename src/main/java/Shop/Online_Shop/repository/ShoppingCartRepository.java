
package Shop.Online_Shop.repository;

import Shop.Online_Shop.model.Product;
import Shop.Online_Shop.model.ShoppingCart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByUserIsCartId(Long userId);
}

