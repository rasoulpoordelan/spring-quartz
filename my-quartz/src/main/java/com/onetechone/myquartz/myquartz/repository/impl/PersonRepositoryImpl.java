package com.onetechone.myquartz.myquartz.repository.impl;

import com.onetechone.myquartz.myquartz.model.Person;
import com.onetechone.myquartz.myquartz.repository.PersonRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


@Repository
public class PersonRepositoryImpl implements PersonRepository {

  @Qualifier("datasource")
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Person> getAll() {
    return entityManager.createQuery("select d from Person d ").getResultList();
  }
}