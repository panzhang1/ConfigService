package com.sf.bizx.rule.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sf.bizx.rule.bean.Rule;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleControllerTest {

    @Autowired
    private RuleController ruleService;

    @Test
    public void getRule() throws Exception {
        Rule rule = ruleService.getRule("ruleVar1");
        Assert.assertEquals("ruleVar1", rule.getName());
        Assert.assertEquals("admin", rule.getLastModifiedBy());
    }
}
