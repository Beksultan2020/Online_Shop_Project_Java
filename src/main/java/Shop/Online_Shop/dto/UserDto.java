package Shop.Online_Shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Long id;
    private String email;
    private String fullName;
//    private String age;
    private int age;


}
