package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converter.StudentConverter;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import com.demo.example.student_library_management_system.requestdto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(StudentRequestDto studentRequestDto) {
        Student student = StudentConverter.convertStudentRequestDtoIntoStudent(studentRequestDto);

        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
        return "Student and card saved successfully";
    }

        public Student getStudentById(int id)
        {
            Optional<Student> studentOptional = studentRepository.findById(id);
            if(studentOptional.isPresent())
            {
                return studentOptional.get();
            }
            return null;
        }

        public List<Student> getAllStudent()
        {
            List<Student> studentList = studentRepository.findAll();
            return studentList;
        }

        public Page<Student> findAllStudentsByPage(int pageNo , int pageSize)
        {
           Page<Student> studentPage = studentRepository.findAll(PageRequest.of(pageNo,pageSize));
           return studentPage;
        }

        public String updateStudent(int id,StudentRequestDto studentRequestDto)
        {
           Student student =  getStudentById(id);
           if(student != null)
           {
               student.setAddress(studentRequestDto.getAddress());
               student.setDepartment(studentRequestDto.getDepartment());
               student.setDob(studentRequestDto.getDob());
               student.setEmail(studentRequestDto.getEmail());
               student.setGender(studentRequestDto.getGender());
               student.setMobile(studentRequestDto.getMobile());
               student.setName(studentRequestDto.getName());
               student.setSemester(studentRequestDto.getSemester());

               studentRepository.save(student);
               return "Student Updated successfully";
           }
           else
           {
               return "Student not found cannot update";
           }

        }
        public String deleteStudentById(int id)
        {
            studentRepository.deleteById(id);
            return "student with id "+id+" deleted";
        }

        public Student findStudentByEmail(String email)
        {
            Student student = studentRepository.findByEmail(email);
            return student;
        }

        public List<Student> findStudentByDepartment(String Dept)
        {
            List<Student> studentList = studentRepository.findByDepartment(dept);
            return studentList;
        }
    }

