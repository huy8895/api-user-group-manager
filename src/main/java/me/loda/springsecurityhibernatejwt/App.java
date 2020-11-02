package me.loda.springsecurityhibernatejwt;
/*******************************************************
 * For Vietnamese readers:
 *    Các bạn thân mến, mình rất vui nếu project này giúp 
 * ích được cho các bạn trong việc học tập và công việc. Nếu 
 * bạn sử dụng lại toàn bộ hoặc một phần source code xin để 
 * lại dường dẫn tới github hoặc tên tác giá.
 *    Xin cảm ơn!
 *******************************************************/

import me.loda.springsecurityhibernatejwt.Repository.IAppRoleRepository;
import me.loda.springsecurityhibernatejwt.model.AppRole;
import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.service.IAppRoleService;
import me.loda.springsecurityhibernatejwt.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import javax.management.relation.Role;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 4/30/2019
 * Github: https://github.com/loda-kun
 */
@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    IAppUserService appUserService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IAppRoleService roleService;

    @Override
    public void run(String... args) throws Exception {
        // Khi chương trình chạy
        // Insert vào csdl một user.
        AppUser user = new AppUser();
        user.setUsername("huy");
        user.setPassword(passwordEncoder.encode("huy"));
        Set<AppRole> roles = new HashSet<>();
        roleService.save(new AppRole("ROLE_ADMIN"));
        roleService.save(new AppRole("ROLE_USER"));
        roles.add(roleService.getRoleByName("ROLE_ADMIN"));
        roles.add(roleService.getRoleByName("ROLE_USER"));
        user.setRoles(roles);
        appUserService.save(user);
        System.out.println(user);
    }

    @PostConstruct
    public void init(){
        if(roleService.getAllRole() == null){

        }
    }
}
