package com.sf.bizx.rule.service;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.anyString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sf.bizx.rule.bean.Rule;
import com.sf.bizx.rule.service.out.UserServiceProxy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleControllerTest {

    @Autowired
    private RuleController ruleService;

    @Mock
    private UserServiceProxy userServiceProxy;
    
    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getRule() throws Exception {
        when(userServiceProxy.getUserDisplayName(anyString())).thenReturn("Emily Clark");
        
        Rule rule = ruleService.getRule("ruleVar1");
        Assert.assertEquals("ruleVar1", rule.getName());
        Assert.assertEquals("Emily Clark", rule.getLastModifiedBy());
    }
}
