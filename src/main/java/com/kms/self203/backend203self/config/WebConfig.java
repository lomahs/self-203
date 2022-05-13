package com.kms.self203.backend203self.config;


import com.kms.self203.backend203self.entity.ERole;
import com.kms.self203.backend203self.entity.Role;
import com.kms.self203.backend203self.logging.BackLogging;
import com.kms.self203.backend203self.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer, CommandLineRunner {

    @Autowired
    BackLogging logging;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logging);
//    }

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role(1, ERole.ROLE_USER));
        roleRepository.save(new Role(2, ERole.ROLE_ADMIN));
    }
}
