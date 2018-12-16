package com.onetechone.myquartz.myquartz.service;

import com.onetechone.myquartz.myquartz.model.Department;
import com.onetechone.myquartz.myquartz.repository.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

  @Autowired
  DepartmentRepository departmentRepository;

  public List<Department> getAllDepartment() {
    return  departmentRepository.getAll();
  }

}
