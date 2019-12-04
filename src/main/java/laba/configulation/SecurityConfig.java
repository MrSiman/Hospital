package laba.configulation;

import laba.security.AuthProviderImp;
import laba.security.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("laba.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProviderImp authProviderImp;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/login", "/login_process").anonymous()
                .antMatchers("/tables", "/patientes/**", "/profession/**", "/doctors/**", "/services/**", "/service_types/**", "/users/**", "/all_complete_services/**", "/reports/**").hasAuthority("ROLE_" + Roles.ADMIN.toString())
                .antMatchers("/login_doctor/**").hasAuthority("ROLE_" + Roles.USER)
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_process")
                .usernameParameter("name")
                .and().logout();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.authenticationProvider(authProviderImp);
    }
}
