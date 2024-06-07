package model.service;

import exception.UserNotFound;
import mapper.Mapper;
import model.User;
import model.dao.UserDao;
import model.dao.UserDaoImpl;
import model.dto.UserDto;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService{
    private final UserDao userDao = new UserDaoImpl();
    @Override
    public List<UserDto> getAllUsers() {
        return userDao.getAllUser()
                .stream()
                .map(Mapper::fromUserToUserDto)
                .toList();
    }

    @Override
    public void addUser(User user) {
        userDao.addNewUser(user);
    }

    @Override
    public void deleteUser(int id) throws UserNotFound{
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
