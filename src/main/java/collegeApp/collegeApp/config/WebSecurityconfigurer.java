package collegeApp.collegeApp.config;

import collegeApp.collegeApp.service.MyUserServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityconfigurer  extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserServiceDetails myUserServiceDetails;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(myUserServiceDetails)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE,"/instructor")
                .hasRole("admin")
                .antMatchers(HttpMethod.POST,"/instructor")
                .hasRole("admin")
                .antMatchers(HttpMethod.PUT,"/instructor")
                .hasRole("admin")
                .antMatchers(HttpMethod.GET)
                .hasAnyRole("admin","User")
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable();
    }
}
