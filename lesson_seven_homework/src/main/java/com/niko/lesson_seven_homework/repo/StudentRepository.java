package com.niko.lesson_seven_homework.repo;

import com.niko.lesson_seven_homework.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
