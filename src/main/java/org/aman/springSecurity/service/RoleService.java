package org.aman.springSecurity.service;

import org.aman.springSecurity.entity.Role;
import org.aman.springSecurity.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
