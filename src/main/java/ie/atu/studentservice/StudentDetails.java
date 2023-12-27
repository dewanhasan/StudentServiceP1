package ie.atu.studentservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {
    private String name;
    private String email;
    private String dob;
    private String course;
    // private int  level;
    //private String courseDuration;
    //private String type;
}