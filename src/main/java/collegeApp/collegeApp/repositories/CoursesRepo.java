package collegeApp.collegeApp.repositories;

import collegeApp.collegeApp.entities.Courses;
import collegeApp.collegeApp.entities.Instructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CoursesRepo extends CrudRepository<Courses,Integer> {
    @Query("select course from Courses course where course.instructor=?1")
    Iterable<Courses> findByInstructor(Instructor instructor);
}
