package com.webthuenha.controller;

import com.webthuenha.model.Role;
import com.webthuenha.service.iService.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roleList = roleService.getAll();
        if (roleList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role), HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Role> getRole(@PathVariable int id) {
        Role currentRole = roleService.findById(id);
        if (currentRole == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentRole, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Role> editRole(@RequestBody Role role, @PathVariable int id) {
        Role currentRole = roleService.findById(id);
        if (currentRole== null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentRole.setName(role.getName());

        return new ResponseEntity<>(roleService.edit( currentRole), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Role> deleteRole(@PathVariable int id) {
        if (roleService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
