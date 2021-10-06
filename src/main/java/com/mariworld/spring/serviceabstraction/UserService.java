package com.mariworld.spring.serviceabstraction;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void upgradeLevels(List<User> users){
        for (User user : users) {
            if(canUpgrade(user)){
                if(user.getLevel()==Level.BASIC)
                user.setLevel(Level.SILVER);
                else if(user.getLevel()==Level.SILVER)
                    user.setLevel(Level.GOLD);
            }
            userDao.update(user);
        }
    }

    private boolean canUpgrade(User user) {
        if(user.getLogin()>=50 || user.getRecommend()>=30){
            return true;
        }return false;
    }
}
