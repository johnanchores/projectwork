package dev2426.ITSProjectWork.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // classe di config
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // regole di sicurezza
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                // solo per testing, da togliere in pubblicazione
                // .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // permette accesso a tutti a queste pagine
                        .requestMatchers("/login", "/register", "/css/**", "/js/**", "/static/**", "/image/**",
                                "/public/**")
                        .permitAll()

                        // altre richieste richiedono autenticazione
                        .anyRequest().authenticated())

                // form di login
                .formLogin(form -> form
                        // visualizza pagina (get)
                        .loginPage("/login")
                        // manda i dati a login (post)
                        .loginProcessingUrl("/login")

                        .defaultSuccessUrl("/loading", true)

                        .permitAll())

                // config logout
                .logout(logout -> logout
                        // permesso a tutti di logout
                        .permitAll()
                        .logoutSuccessUrl("/login?logout"))
                        .rememberMe(rememberMe -> rememberMe
                                .key("chiaveSegretaSicura")
                                .tokenValiditySeconds(1209600) // 2 settimane
                        );

        return http.build();
    }
}