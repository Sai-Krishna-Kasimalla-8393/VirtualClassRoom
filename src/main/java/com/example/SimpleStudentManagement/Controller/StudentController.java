package com.example.SimpleStudentManagement.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.SimpleStudentManagement.Model.Student;
import com.example.SimpleStudentManagement.Repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentRepository.findById(id).orElseThrow());
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/students";
    }
}

