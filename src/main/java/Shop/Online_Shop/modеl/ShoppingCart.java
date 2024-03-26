package Shop.Online_Shop.modеl;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ShoppingCart extends BaseModel{
    private int counter;
    private double totalPrice;
    @OneToMany(fetch = FetchType.LAZY)
    List<Product> productList;

    @OneToOne(fetch = FetchType.LAZY)
    User userIsCart;
}

