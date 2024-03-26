package Shop.Online_Shop.modеl;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {

    private String name;

    private double price;

    private double mark;

    private String description;
    private String image;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Type> types;


}
