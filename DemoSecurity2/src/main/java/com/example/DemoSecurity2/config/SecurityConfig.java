package com.example.DemoSecurity2.config;

import com.example.DemoSecurity2.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/css/**", "/js/**").permitAll()
                // Chỉ Admin mới được vào các link quản lý
                .requestMatchers("/products/new", "/products/edit/**").hasRole("ADMIN")
                // Cả USER và ADMIN đều vào được trang danh sách
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/products", true) // Sau khi login xong sẽ chạy vào Controller ở Bước 1
            )
            .logout(logout -> logout.permitAll());
        
        return http.build();
    }
}