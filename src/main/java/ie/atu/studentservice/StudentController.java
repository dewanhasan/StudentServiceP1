package ie.atu.studentservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Enrolment")
@RestController
public class StudentController {
    private StudentRegClient studentRegClient;
    private  DatabaseService databaseService;


    @Autowired
    public StudentController(StudentRegClient studentRegClient, DatabaseService databaseService){
        this.studentRegClient = studentRegClient;
        this.databaseService = databaseService;
    }

    @GetMapping("/{firstname}/{lastname}")
    public ResponseEntity<?> getStudentDetails(@PathVariable String firstname, @PathVariable String lastname){

        StudentDetails studentDetails = databaseService.getDetailsbyFirstAndLastname(firstname, lastname);

        if(studentDetails == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDetails);
    }

    @GetMapping("/findAllData")
    public ResponseEntity<?> getAllData(){
        List<StudentDetails> studentDetails = databaseService.getAllData();

        if(studentDetails == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentDetails);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        databaseService.deleteStudent(id);
        return new ResponseEntity<>("Student un-enrolled successfully", HttpStatus.OK);
    }

    @PutMapping("/{dob}")
    public ResponseEntity<String> updateStudentDetails(@PathVariable String dob, @RequestBody StudentDetails updatedDetails) {
        databaseService.updateStudentDetails(dob, updatedDetails);
        return new ResponseEntity<>("Student details updated succesfully", HttpStatus.OK);
    }



    @PostMapping("/approved-and-registered")
    public ResponseEntity<Object> approveAndRegister(@Valid @RequestBody StudentDetails studentDetails){
        System.out.println("Student details received at StudentController: " + studentDetails);
        Object response = studentRegClient.someDetails(studentDetails);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/enrol")
    public ResponseEntity<String>enrolment(@Valid @RequestBody StudentDetails studentDetails){
        databaseService.enrol(studentDetails);
        System.out.println("Student Enrolled: " +studentDetails);
        return ResponseEntity.ok("Student enrolled succesfully");
    }


   /* @PostMapping("/approved-and-registered")
    public Object approveAndRegister(@RequestBody StudentDetails studentDetails){
        System.out.println("Student details received at StudentController: " + studentDetails);
        return studentRegClient.someDetails(studentDetails);
    }*/

    /*@PostMapping("/enrol")
    public ResponseEntity<String>enrolment(@Valid @RequestBody StudentDetails studentDetails){
        databaseService.enrol(studentDetails);
        System.out.println("Student Enrolled: " +studentDetails);
        return new ResponseEntity<>("Student enrolled succesfully", HttpStatus.OK);
    }*/



    /*@PostMapping("/approved-and-registered")
    public ResponseEntity<String>enrolment(@Valid @RequestBody StudentDetails studentDetails){
        databaseService.enrol(studentDetails);
        studentRegClient.someDetails(studentDetails);
        System.out.println("Student Enrolled: " +studentDetails);
        return new ResponseEntity<>("Student enrolled succesfully", HttpStatus.OK);
    }*/
}