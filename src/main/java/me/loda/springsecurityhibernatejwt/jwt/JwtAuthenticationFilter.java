package me.loda.springsecurityhibernatejwt.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;
import com.google.common.net.HttpHeaders;
import io.jsonwebtoken.JwtException;
import me.loda.springsecurityhibernatejwt.service.impl.AppUserServiceImpl;
import me.loda.springsecurityhibernatejwt.service.impl.AppUserTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AppUserServiceImpl appUserService;

    @Autowired
    AppUserTokenServiceImpl appUserTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String jwt = getJwtFromRequest(request);
        System.out.println("jwtTOKEN = " + jwt.length());

        if (Strings.isNullOrEmpty(jwt)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            boolean jwtVerified = tokenProvider.validateToken(jwt)
                    && appUserTokenService.isTokenExists(jwt);

            if (jwtVerified) {
                Long userId = tokenProvider.getUserIdFromJWT(jwt);

                UserDetails userDetails = appUserService.loadUserDetailById(userId);
                if (userDetails != null) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails,
                                    null, userDetails.getAuthorities());

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (JwtException ex) {
            log.error("failed on set user authentication", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        // Kiểm tra xem header Authorization có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(tokenProvider.getJWT_TOKEN_PREFIX())) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
