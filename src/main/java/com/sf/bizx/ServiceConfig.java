package com.sf.bizx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig{

  @Value("${user_endpoint}")
  private String userServiceEndPoint;

  public String userServiceEndPoint(){
    return userServiceEndPoint;
  }
}

