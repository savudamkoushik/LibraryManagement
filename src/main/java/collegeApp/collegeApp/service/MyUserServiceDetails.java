package collegeApp.collegeApp.service;

import collegeApp.collegeApp.entities.MyUser;
import collegeApp.collegeApp.entities.UserRoles;
import collegeApp.collegeApp.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyUserServiceDetails implements UserDetailsService {
    private static final Logger logger= LoggerFactory.getLogger(MyUserServiceDetails.class);
    @Autowired
    private UserRepo userRepo;
    @Bean
    public PasswordEncoder getPassword(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        logger.info("enterd into userDetailservice");
        MyUser user=userRepo.findByUsername(s);
        logger.info(user.toString());
        User.UserBuilder builder=User.withUsername(s);
        List<String> roles=new ArrayList<>();
        for(GrantedAuthority userRoles:user.getAuthorities()){
            roles.add(userRoles.getAuthority());
        }
        return builder
                .username(user.getUsername())
                .password(getPassword().encode(user.getPassword()))
                .roles(roles.toArray(new String[roles.size()]))
                .build();
    }
}
