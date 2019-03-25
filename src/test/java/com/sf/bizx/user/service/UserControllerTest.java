package com.sf.bizx.user.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sf.bizx.user.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userService;

    @Test
    public void getUser() throws Exception {
        User user = userService.getUser("admin");
        Assert.assertEquals("admin", user.getName());
        Assert.assertEquals("Emily", user.getFirstName());
        Assert.assertEquals("Clark", user.getLastName());
    }
}
