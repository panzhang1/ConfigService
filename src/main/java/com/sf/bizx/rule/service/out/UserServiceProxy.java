package com.sf.bizx.rule.service.out;

import org.springframework.web.client.RestTemplate;

import com.sf.bizx.user.bean.User;

public class UserServiceProxy {
    private static UserServiceProxy instance = new UserServiceProxy();
    private static final String END_POINT = "http://localhost:8080/user/";
    
    private UserServiceProxy() {
    }
    
    public static UserServiceProxy getInstance() {
        return instance;
    }
    
    /**
     * Rule Service call User Service
     * @param userId
     * @return
     */
    public String getUserDisplayName(String userId) {
        return getUserDisplayNameFromService(END_POINT, userId);
    }
    
    private String formatUser(User user) {
        return String.format("%s %s", user.getFirstName(), user.getLastName());
    }
    
    public String getUserDisplayNameFromService(String serverEndpoint,String userId) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(serverEndpoint + userId, User.class);
        return formatUser(user);
    }
}
