package net.javaguideslivemilton.springboot_rest_api.controller;

import lombok.Getter;
import net.javaguideslivemilton.springboot_rest_api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    //http://localhost:8080/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student= new Student(
            1,
                "milton",
                "munoz"
        );
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok()
                .header("custom-header", "milton")
                .body(student);
    }

    //http://localhost:8080/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"milton","Munoz"));
        students.add(new Student(2,"jhon","Munoz"));
        students.add(new Student(3,"Hilda","Munoz"));
        students.add(new Student(4,"Ferney","Lozano"));

        return ResponseEntity.ok(students);
    }

    //Spring Boot REST API with Path Variable
    // {id} - URI template variable
    // http://localhost://8080/students/1/milton/munoz
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentdId,
                                      @PathVariable("first-name") String firstName,
                                       @PathVariable ("last-name") String lastName){
        Student student = new Student(studentdId, firstName, lastName);
        return ResponseEntity.ok(student);
    }


    // Spring boot REST API with Request Param
    // http://localhost:8080/students/query?id=1&firstName=Milton&lastName=Munoz
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        Student student= new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);

    }
    //Spring boot REST API that handles HTTP POST Request - creating new resource
    // @PostMapping and @RequestBody
    @PostMapping("students/create")
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity <Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot REST API that handles HTTP PUT Request - updating existing resource
    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully!");
    }


}
