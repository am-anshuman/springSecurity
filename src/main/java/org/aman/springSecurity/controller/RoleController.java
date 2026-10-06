package org.aman.springSecurity.controller;

import org.aman.springSecurity.entity.Role;
import org.aman.springSecurity.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<String> addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return ResponseEntity.ok("Role added");
    }
}
