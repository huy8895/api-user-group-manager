package me.loda.springsecurityhibernatejwt.jwt;

import java.util.Date;

import lombok.Data;
import me.loda.springsecurityhibernatejwt.service.impl.AppUserTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import me.loda.springsecurityhibernatejwt.jwt.user.CustomUserDetails;

@Component
@Slf4j
@Data
public class JwtTokenProvider {
    private final String JWT_SECRET = "HM2T";
    private final String JWT_TOKEN_PREFIX = "Bearer ";
    private final long JWT_EXPIRATION = 10 * 60 * 1000L;

    public String generateToken(CustomUserDetails userDetails) {
        // Lấy thông tin user
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                    .setSubject(Long.toString(userDetails.getAppUser().getId()))
                    .claim("authorities", userDetails.getAuthorities())
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                    .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(JWT_SECRET)
                            .parseClaimsJws(token)
                            .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        } catch (Exception e){
            log.error("Exception : "+ e.getClass()+ " : " + e.getMessage());
        }
        return false;
    }
}
