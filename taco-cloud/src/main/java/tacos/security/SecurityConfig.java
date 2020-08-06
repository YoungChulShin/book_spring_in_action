package tacos.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
//            .antMatchers("/design", "/orders")
//                .hasRole("USER")
            .antMatchers("/", "/**")
                .permitAll()
        .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/design")
        .and()
            .logout()
                .logoutSuccessUrl("/")
        .and()
            .csrf();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*
        // 인메모리 기반 사용자 스토어
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password("{noop}password1")
                .authorities("ROLE_USER")
            .and()
                .withUser("user2")
                .password("{noop}password2")
                .authorities("ROLE_USER");
        */

        /*
        // JDBC 기반 사용자 스토어
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(new NoEncodingPasswordEncoder());
         */

        /*
        // LDAP 기반 사용자 정보
        auth.ldapAuthentication()
                .userSearchBase("ou=people")
                .userSearchFilter("(uid={0})")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                .passwordCompare()
                .passwordEncoder(new BCryptPasswordEncoder())
                .passwordAttribute("userPasscode");
         */

        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(encoder());

    }
}
