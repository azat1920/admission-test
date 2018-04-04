package com.netcracker.admissiontest;

import com.netcracker.admissiontest.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AdmissionTestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AdmissionTestApplication.class);
    }

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {

        SpringApplication.run(AdmissionTestApplication.class, args);

    }


/*    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            Role admin = new Role("admin");
//            admin.setUsers(new HashSet<>());

            Role user = new Role("user");
  //          user.setUsers(new HashSet<>());

            roleRepository.save(admin);
            roleRepository.save(user);
        };
    }*/

}


