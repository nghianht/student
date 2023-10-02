package com.example.studentdep.service;

import com.example.studentdep.entity.Department;
import com.example.studentdep.entity.Student;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartment();
    Department findDepartmentById(long id);
    void saveDepartment(Department department);
    void deleteDepartmentById(long id);

}
