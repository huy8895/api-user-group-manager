package me.loda.springsecurityhibernatejwt.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
public class AppRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }

    public AppRole(String name) {
        this.name = name;
    }

    //    // mappedBy trỏ tới tên biến persons ở trong Address.
//    @ManyToMany(mappedBy = "users")
//    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private Collection<AppUser> users;
}
