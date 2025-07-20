package com.hendisantika.springbootexportimportexcelpoi.controller;

import com.hendisantika.springbootexportimportexcelpoi.model.Student;
import com.hendisantika.springbootexportimportexcelpoi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public String showStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        return "student-list"; // tương ứng với templates/student-list.html
    }
}
