package com.example.studentdep.DAO;

import com.example.studentdep.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select s from Student s where s.department_id = :id")
    List<Student> findStudentByDepartmentId(@Param("id") long id);
    @Modifying
    @Transactional
    @Query("DELETE FROM Student s where s.department_id = :id")
    void deleteStudentByDepartmentId(@Param("id") long id);
}
