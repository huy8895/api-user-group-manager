package me.loda.springsecurityhibernatejwt.Repository;

import me.loda.springsecurityhibernatejwt.model.AppUser;
import me.loda.springsecurityhibernatejwt.model.AppUserToken;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
public interface IAppUserTokenRepository  extends JpaRepository<AppUserToken, Long> {
    void removeAllByAppUser(AppUser appUser);
    ArrayList<AppUserToken> getAllByAppUser(AppUser appUser);
    void removeByToken(String token);
    boolean existsAppUserTokenByToken(String token);

}
