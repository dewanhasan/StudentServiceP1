package ie.atu.studentservice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {

    private final DatabaseRepository databaseRepository;

    public DatabaseService(DatabaseRepository databaseRepository){
        this.databaseRepository = databaseRepository;
    }


    //Enrols and save a registered student details.
    public void enrol(StudentDetails studentDetails){

        databaseRepository.save(studentDetails);
    }

    //This is used to get a specific student details by entering students firstname and last name
    public StudentDetails getDetailsbyFirstAndLastname(String firstname, String lastname){

        return databaseRepository.findByFirstnameAndLastname(firstname, lastname);
    }


    // This method is used to delete a registered student by entering the student id.
    public void deleteStudent(Long id){
        databaseRepository.deleteById(id);
    }

    // This method is used to update a specific students information by entering dob
    public void updateStudentDetails(String dob, StudentDetails updatedDetails) {
        Optional<StudentDetails> existingStudentOptional = databaseRepository.findBydob(dob);

        if(existingStudentOptional.isPresent()) {
            StudentDetails existingStudent = existingStudentOptional.get();

            existingStudent.setFirstname(updatedDetails.getFirstname());
            existingStudent.setLastname(updatedDetails.getLastname());
            existingStudent.setEmail(updatedDetails.getEmail());
            existingStudent.setDob(updatedDetails.getDob());
            existingStudent.setCourse(updatedDetails.getCourse());
            existingStudent.setWorkplacement(updatedDetails.getWorkplacement());
            existingStudent.setContact(updatedDetails.getContact());
            existingStudent.setAddress(updatedDetails.getAddress());
            existingStudent.setDisability(updatedDetails.getDisability());
            existingStudent.setStatus(updatedDetails.getStatus());
            databaseRepository.save(existingStudent);
        }else{
            throw new EntityNotFoundException("Student not found with given DoB");
        }
    }

    // This method is used to get all data from the database
    public List<StudentDetails> getAllData() {
        return databaseRepository.findAll();
    }
}
