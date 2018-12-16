package com.onetechone.myquartz.myquartz.repository;


import com.onetechone.myquartz.myquartz.model.Department;
import java.util.List;

public interface DepartmentRepository {

  List<Department> getAll();
}