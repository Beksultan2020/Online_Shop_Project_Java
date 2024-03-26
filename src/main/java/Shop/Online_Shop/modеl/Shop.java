package Shop.Online_Shop.modеl;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shop extends BaseModel{
    private String street;
    private String workTime;
    private String pickup;
    private boolean existProduct;

    @OneToMany()
    List<City> cities;


}
