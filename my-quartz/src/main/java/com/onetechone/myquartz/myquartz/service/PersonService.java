package com.onetechone.myquartz.myquartz.service;

import com.onetechone.myquartz.myquartz.model.Person;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

	 List<Person> getAllPersons();

	 String getName();
}