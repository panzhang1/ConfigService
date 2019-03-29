package com.sf.bizx.rule.service.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sf.bizx.user.bean.User;

@Component
public class UserServiceDiscoverClient {
    private static final String END_POINT = "http://pangu/user/";
    
    @Autowired
    RestTemplate restTemplate;
    
    private String formatUser(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
    
    public String getUserDisplayNameFromService(String userId) {
        User user = restTemplate.getForObject(END_POINT + userId, User.class);
        return formatUser(user);
    }
}
