package collegeApp.collegeApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String email;
    private int age;
    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor")
    @JsonIgnoreProperties("instructorDetail")
    private Instructor instructor;

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", instructor=" + instructor +
                '}';
    }
}
