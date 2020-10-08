package nhat.coder.blogpro.config;

import nhat.coder.blogpro.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailServiceImpl userDetailServiceImp;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceImp).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
//                   .loginPage("/dang-nhap")
                    .defaultSuccessUrl("/blog")
                    .permitAll()
                .and()
                    .authorizeRequests().antMatchers("/blog","/blog/search","/blog/view/*","/category/view-category/*").permitAll()
                    .anyRequest().authenticated()
//                .and()
//                    .authorizeRequests().antMatchers("/search").permitAll()
//                    .anyRequest().authenticated()
                .and()
                    .logout()
                    .permitAll();
    }
}
