package collegeApp.collegeApp.pojo;

import collegeApp.collegeApp.entities.InstructorDetail;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor
@Getter
@Setter
public class InstructorRequest {
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String department;
    @Getter
    @Setter
    private InstructorDetail instructorDetail;
}
