package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;

import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/apis")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        try {
            String response = studentService.saveStudent(studentRequestDto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Some Exception Occured :"+e.getMessage());
        }
    }

    @GetMapping("/find{id}")
    public ResponseEntity<?> findStudentById(@PathVariable int id)
        {
            try {
                Student student = studentService.getStudentById(id);
                return ResponseEntity.ok(student);
            }
            catch (Exception e){
                return ResponseEntity.internalServerError().body("some exception occured :"+e.getMessage());
            }
        }


    @GetMapping("/findAll")
    public List<Student> findAllStudent()
    {
        List<Student> studentList = studentService.getAllStudent();
        return studentList;
    }

    @PutMapping("update/{id}")
    public String updateStudent(@PathVariable int id ,@RequestBody StudentRequestDto studentRequestDto)
    {
       String response = studentService.updateStudent(id,studentRequestDto);
       return response;
    }

    @GetMapping("/findAllByPage")
    public Page<Student> findAllStudentsUsingPage(@RequestParam int pageNo,@RequestParam int pageSize)
    {
        Page<Student> studentPage = studentService.findAllStudentsByPage(pageNo,pageSize);
        return studentPage;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id)
    {
      String response = studentService.deleteStudentById(id);
      return response;
    }

    @GetMapping("/findByEmail")
    public Student findStudentByEmail(@RequestParam String email)
    {
        Student student = studentService.findStudentByEmail(email);
        return student;
    }

    @GetMapping("/findByDept")
    public List<Student> findStudentByDept(@RequestParam String dept)
    {
        List<Student> studentList = studentService.findStudentByDepartment(dept);
        return studentList;
    }


}
