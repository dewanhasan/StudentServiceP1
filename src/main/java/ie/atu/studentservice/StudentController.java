package ie.atu.studentservice;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequestMapping("/Enrolment")
@RestController
public class StudentController {
    private StudentRegClient studentRegClient;
    private  DatabaseService databaseService;


    @Autowired
    public StudentController(StudentRegClient studentRegClient, DatabaseService databaseService){
        this.studentRegClient = studentRegClient;
        this.databaseService = databaseService;
    }

    /*@PostMapping("/enrol-and-confirm")
    public ResponseEntity<String> enrolAndConfirm(@Valid @RequestBody StudentDetails studentDetails) {
        try {
            // Enroll the student via the StudentService (which interacts with the database)
            databaseService.enrol(studentDetails);

            // Communicate with the second microservice (RegistrationClient)
            Object response; studentRegClient.someDetails(studentDetails);

            // Assuming the third microservice is called internally within the RegistrationClient


            System.out.println("Student Enrolled and Confirmed: " + studentDetails);

            return new ResponseEntity<>("Student Enrolled and Confirmed", HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions appropriately
            return new ResponseEntity<>("Error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/


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