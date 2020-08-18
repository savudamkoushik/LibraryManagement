package collegeApp.collegeApp.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserRoles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authority;
    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "userRoles")
    List<MyUser> users;
    @Override
    public String getAuthority() {
        return authority;
    }
}
