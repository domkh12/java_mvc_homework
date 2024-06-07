package model.dao;

import exception.UserNotFound;
import model.User;

import java.util.List;

public interface UserDao {
    void addNewUser(User user);
    void deleteUserById(Integer id) throws UserNotFound;
    void updateUser(User user);
    List<User> getAllUser();
}
