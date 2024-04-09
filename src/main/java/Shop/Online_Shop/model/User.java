package Shop.Online_Shop.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseModel {
    private String email;
    private int age;
    private String fullName;
    private String password;
}
