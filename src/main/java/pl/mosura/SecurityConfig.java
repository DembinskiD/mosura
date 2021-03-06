package pl.mosura;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;







    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }




    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers("/access-denied").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/getDev").authenticated()
                .and()
                .formLogin().permitAll()
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .csrf().disable()
                .logout();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/*.css", "/*.png", "/*.jpg");
    }
}
