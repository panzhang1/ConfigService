package com.sf.bizx.rule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sf.bizx.rule.bean.Rule;

@RestController
public class RuleController {
    
    @RequestMapping("/rule")
    public Rule rule(@RequestParam(value="code", defaultValue="Test") String code) {
        Rule rule =  new Rule();
        rule.setCode(code);
        
        return rule;
    }
}