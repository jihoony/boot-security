package com.ksmartech.bootsecurity.repository;

import com.ksmartech.bootsecurity.dao.UserDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDao, Integer> {
}
