package com.example.studentdep.controller;

import com.example.studentdep.entity.Student;
import com.example.studentdep.service.DepartmentService;
import com.example.studentdep.service.StudentService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    private DepartmentService departmentService;
    @Autowired
    public StudentController(StudentService studentService, DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }
    @GetMapping("/student-list")
    public String findAllStudent(Model model){
        List<Student> students = studentService.findAllStudent();
        model.addAttribute("students", students);
        return "student-list";
    }
    @GetMapping("/add-student")
    public String addStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }
    @GetMapping("update-student")
    public String updateStudent(@RequestParam("id") Integer id, Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student-form";
    }
    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/student-list";
    }
    @GetMapping("delete-student")
    public String delelteStudentById(@RequestParam("id")Integer id, Model model){
        studentService.deleteStudentById(id);
        return "redirect:/student-list";
    }
}
