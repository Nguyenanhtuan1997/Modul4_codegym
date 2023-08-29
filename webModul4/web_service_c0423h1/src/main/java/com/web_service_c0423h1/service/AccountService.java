package com.web_service_c0423h1.service;

import com.web_service_c0423h1.model.Account;
import com.web_service_c0423h1.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    IAccountRepo iAccountRepo;

    public List<Account> getAll(){
        return (List<Account>) iAccountRepo.findAll();
    }
    public List<Account> findAllByUsernameContaining(String username){
        return iAccountRepo.findAllByUsernameContaining(username);
    }

    public Account save(Account account){
        return iAccountRepo.save(account);
    }
    public void delete(int id) {
        iAccountRepo.deleteById(id);
    }

    public Account findById(int id) {
        return iAccountRepo.findById(id).get();
    }


}
