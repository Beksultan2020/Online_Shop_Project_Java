
package Shop.Online_Shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ShoppingCart extends BaseModel{
    private int counter;
    private double totalPrice;
    @OneToMany(fetch = FetchType.EAGER)
    List<Product> productList = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    User userIsCart;
}

