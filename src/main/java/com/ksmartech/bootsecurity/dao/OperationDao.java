package com.ksmartech.bootsecurity.dao;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class OperationDao implements GrantedAuthority {
    @Id
    private String id;

    @Column
    private String description;

    @Override
    public String getAuthority() {
        return id;
    }
}
