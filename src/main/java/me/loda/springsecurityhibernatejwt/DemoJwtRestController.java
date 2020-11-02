package me.loda.springsecurityhibernatejwt;
import com.google.common.net.HttpHeaders;
import me.loda.springsecurityhibernatejwt.jwt.user.CustomUserDetails;
import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.service.impl.AppUserTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import me.loda.springsecurityhibernatejwt.jwt.JwtTokenProvider;
import me.loda.springsecurityhibernatejwt.payload.RandomStuff;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class DemoJwtRestController {

//    @Autowired
//    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AppUserTokenServiceImpl appUserTokenService;

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
           String token = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer ","");
//                appUserTokenService.removeAllByAppUser(appUser);
                appUserTokenService.removeAppToken(token);
                return  token +   " LOGOUT";
            }
        return "logout";
    }

    @GetMapping("/logoutall")
    public String doLogoutAll(HttpServletRequest request){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            String token = request.getHeader(HttpHeaders.AUTHORIZATION).replace("Bearer ","");
            AppUser appUser = ((CustomUserDetails) principal).getAppUser();
            appUserTokenService.removeAllByAppUser(appUser);
            return  token +   " LOGOUT_All";
        }
        return "logout_all";
    }
}
