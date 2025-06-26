package com.sjprogramming.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sjprogramming.bankapp.model.Student;
import com.sjprogramming.bankapp.service.StudentService;

@Controller
public class CrudController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String homepage() {
        return "index";
    }
    
    // Show Students Table
    @GetMapping("/showstu")
    public String showTable(Model model) {
    	model.addAttribute("student", studentService.getAllStudents());
    	return "showstu";
    }

    // Show form to add a new student
    @GetMapping("/form")
    public String reg(Model model) {
    	Student student = new Student();
    	model.addAttribute("student", student);
        return "form";
    }

    // Insert new student data
    @PostMapping("/datainsert")
    public String getData(@RequestParam("id") int id,
                          @RequestParam("name") String name,
                          @RequestParam("address") String address,
                          Model model) {
        Student student = new Student(id, name, address);
        student.setName(name);
        student.setAddress(address);
        studentService.addStudent(student);
        model.addAttribute("student", studentService.getAllStudents());
        return "showstu";
    }

    // Show delete form
    @GetMapping("/delete")
    public String datadelete() {
        return "delete";
    }

    // Delete student by id
    @PostMapping("/datadelete")
    public String deleteData(@RequestParam("id") int id, Model model) {
        boolean deleted = studentService.deleteStudent(id);
        model.addAttribute("student", studentService.getAllStudents());
        model.addAttribute("message", deleted ? "Student deleted successfully." : "Student ID not found.");
        return "showstu";
    }

    // Show update form
    @GetMapping("/update")
    public String dataupdate() {
        return "update";
    }

    // Update student details
    @PostMapping("/dataupdate")
    public String updateData(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("address") String address,
                             Model model) {
        boolean updated = studentService.updateStudent(id, name, address);
        model.addAttribute("student", studentService.getAllStudents());
        model.addAttribute("message", updated ? "Student updated successfully." : "Student ID not found.");
        return "showstu";
    }
}
