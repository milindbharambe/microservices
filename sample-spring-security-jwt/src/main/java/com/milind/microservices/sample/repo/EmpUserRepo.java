package com.milind.microservices.sample.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.milind.microservices.sample.domain.MyUser;

@Repository
public interface EmpUserRepo extends CrudRepository<MyUser, Integer> {

    MyUser findByUserName(String username);

}
