package ie.atu.studentservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "firstname cannot be blank")
    @Size(min = 2, max = 15, message = "Firstname must be between 2 and 15 characters")
    private String firstname;

    @NotBlank(message = "lastname cannot be blank")
    @Size(min = 2, max = 15, message = "Lastname must be between 2 and 15 characters")
    private String lastname;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email cannot be blank")
    @Size(min = 2, max = 30, message = "Email must be between 2 and 30 characters")
    private String email;

    @NotBlank(message = "Date of birth cannot be blank")
    @Size(min = 2, max = 10, message = "Date of birth must be between 2 and 10 characters")
    private String dob;

    @NotBlank(message = "Course cannot be blank")
    @Size(min = 2, max = 60, message = "Course name must be between 2 and 60 characters")
    private String course;


    @NotBlank(message = "Work placement cannot be blank")
    @Size(min = 2, max = 15, message = "Work placement must be between 2 and 15 characters")
    private String workplacement;

    @NotBlank(message = "Contact cannot be blank")
    @Size(min = 2, max = 10, message = "Contact Number must be between 2 and 10 characters")
    private String contact;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 2, max = 60, message = "Address must be between 2 and 60 characters")
    private String address;

    @NotBlank(message = "Disability cannot be blank")
    @Size(min = 2, max = 10, message = "Disability must be between 2 and 10 characters")
    private String disability;

    @NotBlank(message = "status cannot be blank")
    @Size(min = 2, max = 20, message = "status must be between 2 and 20 characters")
    private String status;

}