package com.example.blogapp.controllers;

import com.example.blogapp.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")//used to define base URL for all REST APIs
// so we were using students at the beginning of every URL
public class StudentController {

    // Endpoint for GET request to "/student" at http://localhost:8080/students/student because of the request mapping base URL of students
    @GetMapping("student")
    public ResponseEntity <Student> getStudent() {
        // Create a new Student object with id, first name, and last name initialized to the given values
        Student student = new Student(1, "Lorraine", "Opiyo");

        // Return the created student object, which will be converted to JSON
        //ResponseEntity will return complete http response(this includes the http status like 200 OK or 201 CREATED) with a header and a body
        return new ResponseEntity<>(student, HttpStatus.OK);
        //the above return can also be written as below;
        //return ResponseEntity.ok(student);

        //to add a custom header
        /*
        return ResponseEntity.ok()
                .header("custom-header", "ramesh")
                .body(student);
        */
    }

    //http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Lorraine", "Opiyo"));
        students.add(new Student(2, "John", "Doe"));
        students.add(new Student(3, "Jane", "Doest"));
        students.add(new Student(4, "Joyce", "Day"));
        return ResponseEntity.ok(students);
    }

    //spring boot api with path variable
    //{id} - URI template variable
    //http://localhost:8080/students/1
    // the one at the end is the id that will be given to student...if you write 2 the student id will be 2
    @GetMapping("{id}")
    //@PathVariable is used on a method argument to bind it to the value of a URI template variable...used to assign a specific object to specific value
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id)/*int id can also be written as int studentId, it won't affect anything but you also have to write it in the return statement*/ {
        Student student = new Student(id, "Lorraine", "Opiyo");
        return ResponseEntity.ok(student);
    }

    /*
    (to get multiple path variables you can do this)
    http://localhost:8080/students/3/Lorraine/Opiyo
    this will persist the following values to the variables below
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
         return new Student(studentId, firstName, lastName);
     }
    */

    // spring boot REST API with request params
    // http://localhost:8080/students/query?id=1
    @GetMapping("query")//this URL should be unique that's why we have students/query instead of students coz it has been used before
    //RequestParam is used to extract the values of query parameters in a URL
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id){
        Student student = new Student(id, "Lorraine", "Opiyo");
        return ResponseEntity.ok(student);
    }
    /*
    (for multiple request params)
    http://localhost:8080/students/query?id=1&firstName=Lorraine&lastName=Opiyo
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
          return new Student(id, firstName, lastName);
          }
    */

    //springboot REST API that handles HTTP POST request
    //@PostMapping and RequestBody
    @PostMapping("create")
    //@ResponseStatus(HttpStatus.CREATED)//201 CREATED, this is for REST APIs that handle POST requests(POST is for creating new resource or input of new data)
    //@RequestBody converts JSON into java object using springboot annotation
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);//if we use response entity then no need to use Response Status above hence commented out, they do the same thing
    }

    //springboot REST API for HTTP PUT request(PUT is used to update or change existing data or resource)
    @PutMapping("{id}/update")
    //example of URL in postman will be http://localhost:8080/students/3/update
    //since id is being parsed in the url there's no need for it in the http request as seen below in the print statements
    //if we don't specify response status code like in the above example it automatically returns 200 OK
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //springboot HTTP DELETE request
    @DeleteMapping("{id}/delete")
    //@PathVariable has been used to parse the URL template variable to the method argument name because they are different i.e. {id} and studentId
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);//we're writing in the console to ensure the client will receive the student id
        return ResponseEntity.ok("Student deleted successfully!");
    }


}
