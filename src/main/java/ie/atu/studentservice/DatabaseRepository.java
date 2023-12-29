package ie.atu.studentservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DatabaseRepository extends JpaRepository<StudentDetails, Long> {
    StudentDetails findByFirstnameAndLastname(String firstname, String lastname);
    Optional<StudentDetails> findBydob(String dob);
}
