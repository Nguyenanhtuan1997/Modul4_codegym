package com.web_service_c0423h1.service;

import com.web_service_c0423h1.model.Role;
import com.web_service_c0423h1.repository.IRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private IRoleRepo iRoleRepo;

    public Role findById(int id){
        return iRoleRepo.findById(id).get();
    }
}
