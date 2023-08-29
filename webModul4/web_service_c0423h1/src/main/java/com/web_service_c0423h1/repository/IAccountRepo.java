package com.web_service_c0423h1.repository;

import com.web_service_c0423h1.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAccountRepo extends CrudRepository<Account, Integer> {
    List<Account> findAllByUsernameContaining(String username);

    @Query(value = "select a from Account a where a.username like concat('%',:name,'%')")
    List<Account> findAllByUsernameHQL(String username);
}
