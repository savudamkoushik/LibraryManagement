package collegeApp.collegeApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter
    @Setter
    private String firstName;
    private String department;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructorId")
    @JsonIgnoreProperties("instructor")
    private InstructorDetail instructorDetail;
     

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", department='" + department + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
