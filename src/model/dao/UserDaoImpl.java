package model.dao;

import exception.UserNotFound;
import model.User;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private List<User> userList = new ArrayList<>(
            List.of(new User(1,"KoKo","koko123@gmail.com","123"),
                    new User(2,"KaKa","kaka123@gmail.com", "qwer"))
    );
    @Override
    public void addNewUser(User user) {
        userList.add(user);
    }

    @Override
    public void deleteUserById(Integer id) throws UserNotFound{
        boolean removed = userList.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            throw new UserNotFound("[!] USER ID NOT FOUND");
        }
    }

    @Override
    public void updateUser(User user) {
        userList.stream()
                .filter(e -> e.getId().equals(user.getId()))
                .findFirst()
                .ifPresent(e -> {
                    e.setName(user.getName());
                    e.setEmail(user.getEmail());
                    e.setPassword(user.getPassword());
                });
    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }
}
