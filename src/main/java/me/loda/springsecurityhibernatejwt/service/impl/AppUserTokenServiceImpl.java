package me.loda.springsecurityhibernatejwt.service.impl;

import me.loda.springsecurityhibernatejwt.Repository.IAppUserTokenRepository;
import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.model.AppUserToken;
import me.loda.springsecurityhibernatejwt.service.IAppUserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppUserTokenServiceImpl implements IAppUserTokenService {
    @Autowired
    IAppUserTokenRepository appUserTokenRepository;


    @Override
    public void saveUserToke(AppUserToken appUserToken) {
        this.appUserTokenRepository.save(appUserToken);

    }

    @Override
    public void removeAllByAppUser(AppUser appUser) {
        this.appUserTokenRepository.removeAllByAppUser(appUser);
    }

    @Override
    public boolean isTokenExists(String token) {
        return this.appUserTokenRepository.existsAppUserTokenByToken(token);
    }

    @Override
    public void removeAppToken(String token) {
        this.appUserTokenRepository.removeByToken(token);
    }
}
