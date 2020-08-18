package collegeApp.collegeApp.controller;

import collegeApp.collegeApp.entities.Instructor;
import collegeApp.collegeApp.entities.InstructorDetail;
import collegeApp.collegeApp.pojo.InstructorRequest;
import collegeApp.collegeApp.repositories.InstructorRepo;
import collegeApp.collegeApp.service.MyUserServiceDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MyController {
    private static final Logger logger= LoggerFactory.getLogger(MyController.class);


    @Autowired
    private InstructorRepo instructorRepo;

    @GetMapping("/get")
    public String getHello(){
        logger.info("enterd get menthodfdfsg");
        return "<h1>Hello welocm</h1>";
    }
    @GetMapping("/user")
    public String getUser(){
        return "hello user";
    }
    @GetMapping("/admin")
    public String getAdmin(){
        return "hello admin";
    }

    @PostMapping("/instructor")
    public ResponseEntity<String> storeUser(@RequestBody InstructorRequest instructorRequest){
        Instructor instructor=new Instructor();
        InstructorDetail instructorDetail=new InstructorDetail();
        instructor.setFirstName(instructorRequest.getFirstName());
        instructor.setDepartment(instructorRequest.getDepartment());
        instructorDetail.setAge(instructorRequest.getInstructorDetail().getAge());
        instructorDetail.setEmail(instructorRequest.getInstructorDetail().getEmail());
        instructorDetail.setLastName(instructorRequest.getInstructorDetail().getLastName());
        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetail(instructorDetail);
        instructorRepo.save(instructor);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/instructor")
    public Iterable<Instructor> getUsers(){
        return instructorRepo.findAll();
    }
    @DeleteMapping("/instructor/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable int id){
        Instructor instructor=instructorRepo.findById(id).get();
        instructorRepo.delete(instructor);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/instructor")
    public ResponseEntity<String> deleteItems(){
        instructorRepo.deleteAll();
        return ResponseEntity.ok().build();
    }
    @PutMapping("/instructor/{id}")
    public ResponseEntity<String> updateItem(@PathVariable int id,@RequestBody InstructorRequest instructorRequest){
        Instructor instructor=instructorRepo.findById(id).get();
        InstructorDetail instructorDetail=new InstructorDetail();
        instructor.setDepartment(instructorRequest.getDepartment());
        instructor.setFirstName(instructorRequest.getFirstName());
        instructorDetail.setEmail(instructorRequest.getInstructorDetail().getEmail());
        instructorDetail.setAge(instructorRequest.getInstructorDetail().getAge());
        instructorDetail.setInstructor(instructor);
        instructor.setInstructorDetail(instructorDetail);
//        logger.info(instructor.toString()+" "+instructorDetail.toString());
        instructorRepo.save(instructor);
        return ResponseEntity.ok().build();

    }
}
