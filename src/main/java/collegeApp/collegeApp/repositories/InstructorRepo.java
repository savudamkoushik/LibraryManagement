package collegeApp.collegeApp.repositories;

import collegeApp.collegeApp.entities.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface  InstructorRepo extends CrudRepository<Instructor,Integer> {
}
