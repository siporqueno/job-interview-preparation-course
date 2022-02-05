package com.niko.lesson_seven_homework.controller;

import com.niko.lesson_seven_homework.entity.Student;
import com.niko.lesson_seven_homework.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        LOGGER.info("Students list page requested.");

        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/{id}")
    public String editPage(@PathVariable("id") Long id, Model model) {
        LOGGER.info("Edit page for student with id {} requested.", id);

        model.addAttribute("student", studentRepository.findById(id));
        return "student_form";
    }

    @PostMapping("/{id}")
    public String update(Student student) {
        LOGGER.info("Update endpoint requested.");

        if (student.getId() != null) {
            LOGGER.info("Updating student with id {}", student.getId());
        } else {
            LOGGER.info("Creating new student.");
        }
        studentRepository.save(student);

        return "redirect:/students";
    }

    @GetMapping("/new")
    public String create(Model model) {
        LOGGER.info("Create new student request.");

        model.addAttribute("student", new Student());
        return "student_form";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Long id) {
        LOGGER.info("Student delete requested.");

        studentRepository.deleteById(id);
        return "redirect:/students";
    }

}
