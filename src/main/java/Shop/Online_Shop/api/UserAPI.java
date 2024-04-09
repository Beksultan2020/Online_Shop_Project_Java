package Shop.Online_Shop.api;

import Shop.Online_Shop.Service.impl.UserServiceImpl;
import Shop.Online_Shop.dto.UserDto;
import Shop.Online_Shop.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserAPI {

    private final UserServiceImpl userServiceimpl;
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userServiceimpl.getAllUsers();
    }
    @GetMapping(value="{id}")
    public UserDto getUser(@PathVariable(value="id") Long id){
        return userServiceimpl.getUser(id);
    }

    @GetMapping(value = "/searchUsers/{fullName}")
    public List<UserDto> searchUserByFullName(@PathVariable(value="fullName") String fullName){
        return userServiceimpl.searchUsers(fullName);
    }

    @PostMapping
    public UserDto addUser(@RequestBody User user){
        return userServiceimpl.addUserDto(user);
    }
    @PutMapping("{id}")
    public UserDto updateUser(@PathVariable(value = "id") Long id,@RequestBody UserDto userDto){
        return userServiceimpl.updateUser(id,userDto);
    }
    @PutMapping("/password")
    public String updatePassword(@RequestBody User user){
        return userServiceimpl.updatePassword(user);
    }
    @DeleteMapping(value = "{id}")
    public void deleteUserById(@PathVariable(value="id") Long id){
        userServiceimpl.deleteUserById(id);
    }
}
