package com.mariworld.spring.serviceabstraction;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Autowired
    UserDao userDao;


    public void setUp(){
        userDao.deleteAll();

        User user1 = new User("kim","김길동","1234", Level.BASIC,1,0);
        User user2 = new User("min","민길동","12345678", Level.SILVER,55,10);
        User user3 = new User("gang","강길동","123456", Level.GOLD,100,40);
        userDao.add(user1);
        userDao.add(user2);
        userDao.add(user3);

    }

    private void checkSameUser(User user1, User user2){
        assertEquals(user1.getId(), user2.getId());
        assertEquals(user1.getName(), user2.getName());
        assertEquals(user1.getPassword(), user2.getPassword());
        assertEquals(user1.getLevel(),user2.getLevel());
        assertEquals(user1.getLogin(),user2.getLogin());
        assertEquals(user1.getRecommend(),user2.getRecommend());
    }



    @Test
    public void enumTest(){
        User user= userDao.get("kim");
        userDao.getAll().stream().forEach(System.out::println);

    }

    @Test
    public void updateTest(){
        userDao.deleteAll();
        User user1 = new User("kim","김길동","1234", Level.BASIC,1,0);
        userDao.add(user1);
        user1.setName("김민수");
        userDao.update(user1);
        assertEquals(userDao.get("kim").getName(),"김민수");
        checkSameUser(userDao.get("kim"),user1);
    }
}
