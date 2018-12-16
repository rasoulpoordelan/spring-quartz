package com.onetechone.myquartz.myquartz.repository.impl;

import com.onetechone.myquartz.myquartz.model.Department;
import com.onetechone.myquartz.myquartz.repository.DepartmentRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> getAll() {
      return entityManager.createQuery("select d from Department d ").getResultList();
    }
  }