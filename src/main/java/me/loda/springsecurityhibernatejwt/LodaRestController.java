package me.loda.springsecurityhibernatejwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import me.loda.springsecurityhibernatejwt.jwt.JwtTokenProvider;
import me.loda.springsecurityhibernatejwt.payload.RandomStuff;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
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
