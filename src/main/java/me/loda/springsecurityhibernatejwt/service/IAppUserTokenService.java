package me.loda.springsecurityhibernatejwt.service;

import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.model.AppUserToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserTokenService{
    void saveUserToke(AppUserToken appUserToken);
    void removeAllByAppUser(AppUser appUser);
    boolean isTokenExists(String token);
    void removeAppToken(String token) ;
}
