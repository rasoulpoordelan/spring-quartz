package com.onetechone.myquartz.myquartz.repository;


import com.onetechone.myquartz.myquartz.model.Person;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository {

  List<Person> getAll();
}