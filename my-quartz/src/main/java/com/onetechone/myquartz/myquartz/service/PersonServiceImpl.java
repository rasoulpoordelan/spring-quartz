package com.onetechone.myquartz.myquartz.service;

import com.onetechone.myquartz.myquartz.model.Person;
import com.onetechone.myquartz.myquartz.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPersons() {
		return  personRepository.getAll();
	}

	@Override
	public String getName() {
		return "quartz service";
	}

}