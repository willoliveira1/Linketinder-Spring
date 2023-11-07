package br.com.linketinder.auxiliar.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//TODO
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        try {
//            auth
//                .userDetailsService()
//                .passwordEncoder(passwordEncoder());
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest()
                    .authenticated()
            .and()
                .httpBasic();
//                .antMatchers("/api/beneficios/**") // TODO
//                    .permitAll()




    }
}
