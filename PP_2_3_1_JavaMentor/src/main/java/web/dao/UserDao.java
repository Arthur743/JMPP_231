package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void updateUser(int id, User user);

    User getUser(int id);

    void deleteUser(int id);

    void setUser(User user);
}
