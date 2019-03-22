package paulinastapor.booky.roles;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String roleName;

    public Role(String roleName) {
      this.roleName = roleName;
    }
}
