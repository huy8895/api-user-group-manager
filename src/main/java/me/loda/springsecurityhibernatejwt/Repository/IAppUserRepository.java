package me.loda.springsecurityhibernatejwt.Repository;


import me.loda.springsecurityhibernatejwt.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findAppUserByUsername(String userName);
    boolean existsAppUserByUsername(String userName);
    AppUser findTopByOrderByIdDesc();
    @Query(value = "select * from user",nativeQuery = true)
    List<AppUser> getAllUser();
}
