package com.mariworld.spring.serviceabstraction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
public class UserService {
    public static final int MIN_lOGCOUNT_FOR_SILVER=50;
    public static final int MIN_RECCOUNT_FOR_GOLD=30;


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
        if(user.getLogin()>=MIN_lOGCOUNT_FOR_SILVER && user.getLevel()==Level.BASIC)
            return true;
        else if(user.getRecommend()>=MIN_RECCOUNT_FOR_GOLD && user.getLevel()==Level.SILVER){
            return true;
        }return false;
    }


}
