package ie.atu.studentservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseRepository extends JpaRepository<StudentDetails, Long> {
}
