package ie.atu.studentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnroledStudentData implements CommandLineRunner {

    private final DatabaseRepository databaseRepository;

    @Autowired
    public EnroledStudentData(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        StudentDetails Student1 = new StudentDetails(1L, "Dewan", "Hasan", "dewan@atu.ie", "08-08-2001", "Software and Electronics Engineering", "Included", "0896137067", "8 Claregalway, Galway", "None", "Registered");
        StudentDetails Student2 = new StudentDetails(2L, "Patrick", "Feeney", "patrick@atu.ie", "15-12-2003", "Software and Electronics Engineering", "Included", "0876439067", "7 Cherry Park, Galway", "None", "Registered");
        StudentDetails Student3 = new StudentDetails(3L, "Lucas", "Jeanes", "lucas@atu.ie", "22-10-1996", "Biomedical Engineering", "Included", "0876787662", "2 Merview, Galway", "None", "Registered");
        StudentDetails Student4 = new StudentDetails(4L, "James", "Albright", "james@atu.ie", "12-02-2002", "Mathematics", "Not Included", "0836197067", "3 Newcastle, Galway", "None", "Registered");
        StudentDetails Student5 = new StudentDetails(5L, "Gavin", "Walsh", "gavin@atu.ie", "05-04-2003", "Economics", "Included", "0896839267", "8 Moycullen, Galway", "None", "Registered");
        databaseRepository.save(Student1);
        databaseRepository.save(Student2);
        databaseRepository.save(Student3);
        databaseRepository.save(Student4);
        databaseRepository.save(Student5);
    }
}
