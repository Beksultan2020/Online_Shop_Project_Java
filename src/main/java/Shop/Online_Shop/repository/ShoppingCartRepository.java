
package Shop.Online_Shop.repository;

import Shop.Online_Shop.modеl.Product;
import Shop.Online_Shop.modеl.ShoppingCart;
import Shop.Online_Shop.modеl.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    ShoppingCart findByUserIsCartId(Long userId);
    List<ShoppingCart> findAllByProductList(List<Product> products);

}

