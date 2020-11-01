package me.loda.springsecurityhibernatejwt;
/*******************************************************
 * For Vietnamese readers:
 *    Các bạn thân mến, mình rất vui nếu project này giúp 
 * ích được cho các bạn trong việc học tập và công việc. Nếu 
 * bạn sử dụng lại toàn bộ hoặc một phần source code xin để 
 * lại dường dẫn tới github hoặc tên tác giá.
 *    Xin cảm ơn!
 *******************************************************/

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import me.loda.springsecurityhibernatejwt.jwt.JwtTokenProvider;
import me.loda.springsecurityhibernatejwt.payload.LoginRequest;
import me.loda.springsecurityhibernatejwt.payload.LoginResponse;
import me.loda.springsecurityhibernatejwt.payload.RandomStuff;
import me.loda.springsecurityhibernatejwt.user.CustomUserDetails;

/**
 * Copyright 2019 {@author Loda} (https://loda.me).
 * This project is licensed under the MIT license.
 *
 * @since 5/1/2019
 * Github: https://github.com/loda-kun
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200/")
public class LodaRestController {

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

}
