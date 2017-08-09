package com.example.demo.dao;

import com.example.demo.domain.Child;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ChildRepository extends CrudRepository<Child, Long> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public Page findByNameStartsWith(@Param("name") String name, Pageable p);

    @Query("select c from Child c "
            + "where (:familyName='' or c.familyName=:familyName) ")
            Page findBy(@Param("familyName") String familyName,
            Pageable page);
}

