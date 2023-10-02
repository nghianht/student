package com.example.studentdep.service;

import com.example.studentdep.DAO.DepartmentRepository;
import com.example.studentdep.entity.Department;
import com.example.studentdep.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartmentById(long id) {
        Optional<Department> result = departmentRepository.findById(id);
        Department department = null;
        if(result.isPresent()){
           department = result.get();
        }
        else {
            throw new RuntimeException("Chiu, k tim thay department do");
        }
        return  department;
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(long id) {
        departmentRepository.deleteById( id);
    }
}
