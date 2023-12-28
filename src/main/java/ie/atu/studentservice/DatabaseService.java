package ie.atu.studentservice;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

    private final DatabaseRepository databaseRepository;

    public DatabaseService(DatabaseRepository databaseRepository){
        this.databaseRepository = databaseRepository;
    }


    public void enrol(StudentDetails studentDetails){
        databaseRepository.save(studentDetails);
    }
}
