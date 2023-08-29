package service;

import model.User;
import service.IService.ISeviceUser;

import java.util.ArrayList;

public class UserService implements ISeviceUser<User> {
    ArrayList<User> users = new ArrayList<>();
    public UserService() {
        users.add(new User(1, "Tuan", "1", "user"));
    }

    @Override
    public void add(User user) {
    this.users.add(user);
    }

    @Override
    public boolean checkUser(String userName, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (userName.equals(users.get(i).getUserName()) && password.equals(users.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getIdUser(String userName, String password) {
        for (int i = 0; i < users.size(); i++) {
            if(userName.equals(users.get(i).getUserName()) && password.equals(users.get(i).getPassword())) {
                return users.get(i).getId();
            }
        }
        return -1;
    }
}
