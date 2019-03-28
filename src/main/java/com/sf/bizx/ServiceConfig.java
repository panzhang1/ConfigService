package com.sf.bizx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig{

  @Value("${user_endpoint}")
  private String userServiceEndPoint;
  
  @Value("${user_version}")
  private String userServiceVersion;

  public String userServiceEndPoint(){
    return userServiceEndPoint;
  }
  
  public String userServiceVersion(){
      return userServiceVersion;
    }
}

