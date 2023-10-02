package com.example.studentdep.service;

import com.example.studentdep.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student findStudentById(long id);
    void saveStudent(Student student);
    void deleteStudentById(long id);
    void deleteStudentByDepartmentId(long id);
    List<Student> findStudentByDepartmentId(long id);
}
