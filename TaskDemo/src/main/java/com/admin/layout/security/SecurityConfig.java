package com.admin.layout.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain  securityFilterChain(HttpSecurity http)throws Exception{
		http
		 .csrf(csrf -> csrf.disable())
         .cors(cors -> cors.disable())
         .authorizeHttpRequests(req -> req
                 
                 .requestMatchers("/api/layout/getAllLayouts").hasRole("ADMIN")
                 .requestMatchers("/api/layout/getAllLayouts").hasRole("ADMIN")
                 .requestMatchers("/api/assignment/assign").hasRole("ADMIN")
                 .requestMatchers("/api/assignment/updatetest").hasRole("ADMIN")
                 .requestMatchers("/api/assignment/user-layout").hasRole("USER")
                 .requestMatchers("/api/assignment/group-layout").hasRole("USER")
                 .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
 return http.build();
}
	@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("user123"))
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
