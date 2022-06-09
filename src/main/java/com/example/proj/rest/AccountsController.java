package com.example.proj.rest;

import java.util.Map;

import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.example.proj.model.Account;
import com.opensymphony.xwork2.ModelDriven;

public class AccountsController implements ModelDriven<Object> {
    private static final long serialVersionUID = 1L; 
    private Object model;
    private Account account = new Account("John", "Doe", 22, "test@email.com", "123456", "Author");
    private AccountsRepository accountRepository = new AccountsRepository();
    private static Map<String, Account> map;
    {
        map = accountRepository.findAllAccounts();
    }
    public HttpHeaders index() {
        model = map;
        return new DefaultHttpHeaders("index").disableCaching();
    }    
    @Override
    public Object getModel() {
        if (model != null) {
            return model;
        }
        return account;
    }
    public HttpHeaders create() {
        accountRepository.save(account); 
        return new DefaultHttpHeaders("create");
    }
}