package com.web_service_c0423h1.controller;

import com.web_service_c0423h1.model.Account;
import com.web_service_c0423h1.service.AccountService;
import com.web_service_c0423h1.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    RoleService roleService;

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable int id){
        return accountService.findById(id);
    }

    @GetMapping("/search")
    public List<Account> findByUsernameContain(String username){
        return accountService.findAllByUsernameContaining(username);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
    }


  @PostMapping("/edit")
    public String edit(@RequestBody Account account) {
        accountService.save(account);
        return "ok da sua";
    }
}
