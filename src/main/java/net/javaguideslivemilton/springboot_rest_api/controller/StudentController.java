package net.javaguideslivemilton.springboot_rest_api.controller;

import lombok.Getter;
import net.javaguideslivemilton.springboot_rest_api.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent(){
        Student student= new Student(
            1,
                "milton",
                "munoz"
        );
        return student;
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"milton","Munoz"));
        students.add(new Student(2,"jhon","Munoz"));
        students.add(new Student(3,"Hilda","Munoz"));
        students.add(new Student(4,"Ferney","Lozano"));

        return students;
    }

    //Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost://8080/students/1/milton/munoz
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentdId,
                                      @PathVariable("first-name") String firstName,
                                       @PathVariable ("last-name") String lastName){
        return new Student(studentdId, firstName, lastName);
    }

}
