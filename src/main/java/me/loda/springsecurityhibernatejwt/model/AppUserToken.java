package me.loda.springsecurityhibernatejwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class AppUserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AppUser appUser;
    @Column(length = 350)
    private String token;

    public AppUserToken(AppUser appUser, String token) {
        this.appUser = appUser;
        this.token = token;
    }

}
