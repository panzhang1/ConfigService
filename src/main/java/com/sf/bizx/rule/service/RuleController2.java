package com.sf.bizx.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.ServiceConfig;
import com.sf.bizx.rule.bean.Rule;
import com.sf.bizx.rule.dao.RuleDAO;
import com.sf.bizx.rule.service.out.UserServiceProxy;

@RestController
public class RuleController2 {
    
    @Autowired
    RuleDAO ruleDao;
   
    @Autowired
    ServiceConfig config;
    
    @RequestMapping(value = "/ruleviaconfig",method= RequestMethod.GET)
    public Rule getRuleViaConfig(@RequestParam(value="code") String code) {
        Rule rule = null;
        List<Rule> rules = ruleDao.loadRule(code);
        if (rules.isEmpty()) {
            rule =  new Rule();
            rule.setCode(code);
        } else {
            rule = rules.get(0);
        }
        
        String displayName = UserServiceProxy.getInstance().getUserDisplayNameFromService(config.userServiceEndPoint(), rule.getLastModifiedBy());
        rule.setLastModifiedBy(displayName + "," + config.userServiceVersion());
        return rule;
    }
}