package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.UserService;
import Shop.Online_Shop.dto.UserDto;
import Shop.Online_Shop.mapper.UserMapper;
import Shop.Online_Shop.model.User;
import Shop.Online_Shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.toDtoList(userList);
    }


    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.toDto(user);
    }

    @Override
    public UserDto addUserDto(User user) {
        User newUser = userRepository.findByEmail(user.getEmail());
        if (newUser == null) {
            newUser = userRepository.save(user);
            UserDto newUserDto = userMapper.toDto(newUser);
            return newUserDto;
        }
        return null;
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User userToUpdate = userRepository.findById(id).orElseThrow();
        userToUpdate.setFullName(userDto.getFullName());
        userToUpdate.setAge(userDto.getAge());
        User updatedUser = userRepository.save(userToUpdate);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public String updatePassword(User user) {
        User currentUser = userRepository.findByEmail(user.getEmail());
        if (currentUser != null) {
            currentUser.setPassword(user.getPassword());
            userRepository.save(currentUser);
            return "success";
        }
        return "error";
    }

    @Override
    public List<UserDto> searchUsers(String fullName) {
        List<User> userList = userRepository.findAllByFullNameIgnoreCaseContaining(fullName);
        return userMapper.toDtoList(userList);
    }
}
