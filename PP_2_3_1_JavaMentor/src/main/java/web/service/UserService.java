package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void updateUser(int id, User user);

    User getUser(int id);

    void deleteUser(int id);

    void setUser(User user);
}
