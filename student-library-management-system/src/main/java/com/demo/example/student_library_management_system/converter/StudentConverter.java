package com.demo.example.student_library_management_system.converter;

import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;

public class StudentConverter {

    public static Student convertStudentRequestDtoIntoStudent(StudentRequestDto studentRequestDto)
    {
        Student student = new Student();

        student.setAddress(studentRequestDto.getAddress());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setDob(studentRequestDto.getDob());
        student.setEmail(studentRequestDto.getEmail());
        student.setGender(studentRequestDto.getGender());
        student.setMobile(studentRequestDto.getMobile());
        student.setName(studentRequestDto.getName());
        student.setSemester(studentRequestDto.getSemester());

        return student;
    }

}
