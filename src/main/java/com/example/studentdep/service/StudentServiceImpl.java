package com.example.studentdep.service;

import com.example.studentdep.DAO.StudentRepository;
import com.example.studentdep.entity.Department;
import com.example.studentdep.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(long id) {
        Student student = null;
        Optional<Student> result = studentRepository.findById(id);
        if (result.isPresent()){
            student = result.get();
        }
        else {
            throw  new RuntimeException("Khong ton tai id"+id);
        }
        return student;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteStudentByDepartmentId(long id) {
        studentRepository.deleteStudentByDepartmentId(id);
    }

    @Override
    public List<Student> findStudentByDepartmentId(long id) {
        return studentRepository.findStudentByDepartmentId(id);
    }
}
