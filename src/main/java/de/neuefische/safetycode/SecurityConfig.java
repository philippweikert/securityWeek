package de.neuefische.safetycode;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Philipp")
                .password("p4ssw0rt").roles("ADMIN")
                .and()
                .withUser("Wickbert")
                .password("zuLeicht").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/api/greetings").hasAnyRole("USER", "ADMIN")
                .and()
                .authorizeRequests()
                .mvcMatchers("/api/adminmessage").hasRole("ADMIN")
                .and().authorizeRequests()
                .antMatchers("/**").authenticated()
                .and().formLogin()
                .and().httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return NoOpPasswordEncoder.getInstance();
    }
}
