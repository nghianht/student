package com.example.studentdep.controller;

import com.example.studentdep.entity.Department;
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
public class DepartmentController {
    private DepartmentService departmentService;
    private StudentService studentService;
    @Autowired

    public DepartmentController(DepartmentService departmentService, StudentService studentService) {
        this.departmentService = departmentService;
        this.studentService = studentService;
    }
    @GetMapping("/department-list")
    public String findAllDepartment(Model model){
        List<Department> departments = departmentService.findAllDepartment();
        model.addAttribute("departments", departments);
        return "department-list";
    }
    @GetMapping("show-department")
    public String getStudentsByDepartmentId(@RequestParam("id") Integer id, Model model){
        Department department = departmentService.findDepartmentById(id);
        List<Student> students = studentService.findStudentByDepartmentId(id);
        model.addAttribute("students", students);
        model.addAttribute("department", department);
        return "student-by-department";
    }
    @GetMapping("/add-department")
    public String addDpartment(Model model){
        Department department = new Department();
        model.addAttribute("department", department);
        return "department-form";
    }
    @GetMapping("/update-department")
    public String updateDepartment(@RequestParam("id")Integer id, Model model){
        Department department = departmentService.findDepartmentById(id);
        model.addAttribute("department", department);
        return "department-form";
    }
    @PostMapping("/save-department")
    public String saveDepartment(@ModelAttribute("department")Department department){
        departmentService.saveDepartment(department);
        return "redirect:/department-list";
    }
    @GetMapping("/delete-department")
    public String deleteDepartment(@RequestParam("id") Integer id, Model model){
        departmentService.deleteDepartmentById(id);
        studentService.deleteStudentByDepartmentId(id);
        return "redirect:/department-list";
    }
}
