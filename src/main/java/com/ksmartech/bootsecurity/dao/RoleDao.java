package com.ksmartech.bootsecurity.dao;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "role")
public class RoleDao implements GrantedAuthority {
    @Id
    private String id;

    @OneToMany
    private final List<OperationDao> allowedOperations = new ArrayList<>();

    @Override
    public String getAuthority() {
        return id;
    }

    public Collection<OperationDao> getAllowedOperations() {
        return allowedOperations;
    }
}
