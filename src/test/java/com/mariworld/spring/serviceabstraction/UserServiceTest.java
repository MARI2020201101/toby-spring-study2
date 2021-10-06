package com.mariworld.spring.serviceabstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @Test
    public void upgradeUserTest(){
        userDao.deleteAll();

        User user1 = new User("kim","김길동","1234", Level.BASIC,55,0);
        User user2 = new User("min","민길동","12345678", Level.SILVER,10,40);
        User user3 = new User("gang","강길동","123456", Level.GOLD,100,40);
        List<User> users = List.of(user1, user2, user3);
        userDao.add(user1);
        userDao.add(user2);
        userDao.add(user3);


        userService.upgradeLevels(users);
        assertEquals(userDao.get(user1.getId()).getLevel(), Level.SILVER);
        assertEquals(userDao.get(user2.getId()).getLevel(), Level.GOLD);
        assertEquals(userDao.get(user3.getId()).getLevel(), Level.GOLD);
    }

    @Test
    public void upgradeUserTest2(){
        userDao.deleteAll();

        User user1 = new User("kim","김길동","1234", Level.BASIC,55,0);
        User user2 = new User("min","민길동","12345678", Level.SILVER,10,40);
        User user3 = new User("gang","강길동","123456", Level.GOLD,100,40);
        User user4 = new User("ni","홍길동","12", Level.BASIC,1,40);
        User user5 = new User("guu","조길동","123456789", Level.SILVER,55,40);
        List<User> users = List.of(user1, user2, user3, user4, user5);
        userDao.add(user1);
        userDao.add(user2);
        userDao.add(user3);
        userDao.add(user4);
        userDao.add(user5);


        userService.upgradeLevels(users);
        checkLevel(user1, Level.SILVER);
        checkLevel(user2, Level.GOLD);
        checkLevel(user3, Level.GOLD);
        checkLevel(user4, Level.BASIC);
        checkLevel(user5, Level.GOLD);
    }

    private boolean checkLevel(User user1 , Level level){
        return  userDao.get(user1.getId()).getLevel() == level;
    }

    @Test
    public void upgradeUserTest3(){
        userDao.deleteAll();

        User user1 = new User("kim","김길동","1234", Level.BASIC,55,0);
        User user2 = new User("min","민길동","12345678", Level.SILVER,10,40);
        User user3 = new User("gang","강길동","123456", Level.GOLD,100,40);
        User user4 = new User("ni","홍길동","12", Level.BASIC,1,40);
        User user5 = new User("guu","조길동","123456789", Level.SILVER,55,40);
        List<User> users = List.of(user1, user2, user3, user4, user5);
        userService.addUsers(users);
        userService.upgradeLevels(users);

        checkLevel(user1, Level.SILVER);
        checkLevel(user2, Level.GOLD);
        checkLevel(user3, Level.GOLD);
        checkLevel(user4, Level.BASIC);
        checkLevel(user5, Level.GOLD);
    }

}
