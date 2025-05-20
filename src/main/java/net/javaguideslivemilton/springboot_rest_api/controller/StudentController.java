package net.javaguideslivemilton.springboot_rest_api.controller;

import lombok.Getter;
import net.javaguideslivemilton.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Milton&lastName=Munoz
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }
    //Spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return  student;
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }



}
