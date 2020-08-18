package collegeApp.collegeApp.helperClasses;

import collegeApp.collegeApp.entities.Courses;
import collegeApp.collegeApp.entities.Instructor;
import collegeApp.collegeApp.repositories.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HelperClasses {
    @Autowired
    private CoursesRepo coursesRepo;
    public void deleteCourse(Instructor instructor) {
        Iterable<Courses> courses= coursesRepo.findByInstructor(instructor);
        courses.forEach(course-> {
            course.setInstructor(null);
            coursesRepo.save(course);
        });
    }

    public void deleteMappingForAllCourses(Iterable<Instructor> instructors) {
        instructors.forEach(instructor -> {
            Iterable<Courses> courses= coursesRepo.findByInstructor(instructor);
            courses.forEach(course-> {
                course.setInstructor(null);
                coursesRepo.save(course);
            });
        });
    }
}
