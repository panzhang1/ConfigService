package com.sf.bizx.rule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.rule.bean.Rule;
import com.sf.bizx.rule.dao.RuleDAO;
import com.sf.bizx.rule.service.out.UserServiceProxy;

@RestController
public class RuleController {
    
    @Autowired
    RuleDAO ruleDao;
    
    @RequestMapping(value = "/rule",method= RequestMethod.GET)
    public Rule getRule(@RequestParam(value="code") String code) {
        Rule rule = null;
        List<Rule> rules = ruleDao.loadRule(code);
        if (rules.isEmpty()) {
            rule =  new Rule();
            rule.setCode(code);
        } else {
            rule = rules.get(0);
        }
        
        String displayName = UserServiceProxy.getInstance().getUserDisplayName(rule.getLastModifiedBy());
        rule.setLastModifiedBy(displayName);
        return rule;
    }
}