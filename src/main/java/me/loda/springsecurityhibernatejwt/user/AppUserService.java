package me.loda.springsecurityhibernatejwt.user;
/*******************************************************
 * For Vietnamese readers:
 *    Các bạn thân mến, mình rất vui nếu project này giúp 
 * ích được cho các bạn trong việc học tập và công việc. Nếu 
 * bạn sử dụng lại toàn bộ hoặc một phần source code xin để 
 * lại dường dẫn tới github hoặc tên tác giá.
 *    Xin cảm ơn!
 *******************************************************/

import javax.transaction.Transactional;

import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.service.IAppRoleService;
import me.loda.springsecurityhibernatejwt.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 4/30/2019
 * Github: https://github.com/loda-kun
 */
@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private IAppUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser appUser = userService.getUserByUserName(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(appUser);
    }

    // JWTAuthenticationFilter sẽ sử dụng hàm này
    @Transactional
    public UserDetails loadUserById(Long id) {
        AppUser appUser = userService.getUserById(id).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        return new CustomUserDetails(appUser);
    }


}
