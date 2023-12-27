package ie.atu.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private final StudentRegClient studentRegClient;

    @Autowired
    public StudentController(StudentRegClient studentRegClient){
        this.studentRegClient = studentRegClient;
    }

    @PostMapping("/approved-and-registered")
    public Object approveAndRegister(@RequestBody StudentDetails studentDetails){
        System.out.println("Student details received at StudentController: " + studentDetails);
        return studentRegClient.someDetails(studentDetails);
    }
}