package Shop.Online_Shop.model;


import Shop.Online_Shop.repository.ShoppingCartRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.PostPersist;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
@Component
public class User extends BaseModel {
    private String email;
    private int age;
    private String fullName;
    private String password;
    private double balance;
}
