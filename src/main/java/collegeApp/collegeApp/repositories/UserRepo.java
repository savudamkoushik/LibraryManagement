package collegeApp.collegeApp.repositories;

import collegeApp.collegeApp.entities.MyUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends CrudRepository<MyUser,Integer> {
    public MyUser findByUsername(String s);
}
