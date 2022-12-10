package Creando.CRUD.CrudSpringBoot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    // ! AUTENTICACION O INICIO DE SESION
    
    @Autowired
    private UserDetailsService userDetail;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetail).passwordEncoder(passwordEncoder());
    }
        
    // ! PROTECCION URLS

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.authorizeRequests()
            
            .antMatchers("/editar/**", "/agregar**", "/eliminar/**")
                .hasRole("ADMIN")
            .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
            .and()
            .formLogin()
            .loginPage("/login") // indicamos la pagina de login
            .and()
            // Pagina de error
            .exceptionHandling().accessDeniedPage("/errores/403")
            ;
        http.csrf()
            .disable();
    }
}
