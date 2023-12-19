package com.example.demoForJpa.repo;

import com.example.demoForJpa.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
