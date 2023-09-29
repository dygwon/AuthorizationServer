package com.example.authorizationserver;

import com.example.authorizationserver.users.TacoUser;
import com.example.authorizationserver.users.TacoUserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Bean
    public ApplicationRunner dataLoader(TacoUserRepository userRepository, PasswordEncoder encoder) {
        return args -> {
            userRepository.save(new TacoUser("habuma", encoder.encode("password"), "ROLE_ADMIN"));
            userRepository.save(new TacoUser("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }

}
