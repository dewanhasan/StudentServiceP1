package ie.atu.studentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "student-service", url = "http://localhost:8082")
public interface StudentRegClient {
    @PostMapping("/approved")
    Map<String,String> someDetails(@RequestBody StudentDetails studentDetails);
}