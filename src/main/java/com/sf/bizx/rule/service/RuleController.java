package com.sf.bizx.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.rule.bean.Rule;
import com.sf.bizx.rule.dao.RuleDAO;

@RestController
public class RuleController {
    
    @Autowired
    RuleDAO ruleDao;
    
    @RequestMapping(value = "/rule",method= RequestMethod.GET)
    public Rule rule(@RequestParam(value="code", defaultValue="Test") String code) {
        
        List<Rule> rules = ruleDao.loadRule(code);
        if (rules.isEmpty()) {
            Rule rule =  new Rule();
            rule.setCode(code);
            
            return rule;
        } else {
            return rules.get(0);
        }
    }
}