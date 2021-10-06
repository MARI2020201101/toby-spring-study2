package com.mariworld.spring.serviceabstraction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void addUsers(List<User> users){
        for (User user : users) {
            if (user.getLevel()==null)
                user.setLevel(Level.BASIC);
            userDao.add(user);
        }
    }

    public void upgradeLevels(List<User> users){
        for (User user : users) {
            if(canUpgrade(user)){
                user.upgradeLevel();
            }
            userDao.update(user);
        }
    }

    private boolean canUpgrade(User user) {
        if(user.getLogin()>=50 && user.getLevel()==Level.BASIC)
            return true;
        else if(user.getRecommend()>=30 && user.getLevel()==Level.SILVER){
            return true;
        }return false;
    }


}
