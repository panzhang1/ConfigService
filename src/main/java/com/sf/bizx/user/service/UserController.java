package com.sf.bizx.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.user.bean.User;
import com.sf.bizx.user.dao.UserDAO;

@RestController
public class UserController {
    
    @Autowired
    UserDAO userDao;
    
    @RequestMapping(value = "/user/{userId}",method= RequestMethod.GET)
    public User getUser(@PathVariable(value="userId") String userId) {
        return userDao.getUser(userId);
    }
}