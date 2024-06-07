package model.service;

import exception.UserNotFound;
import model.User;
import model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    void addUser(User user);
    void deleteUser(int id) throws UserNotFound;
    void updateUser(User user);
}
