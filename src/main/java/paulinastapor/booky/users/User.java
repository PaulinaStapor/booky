package paulinastapor.booky.users;

import lombok.Getter;
import lombok.Setter;
import paulinastapor.booky.books.Book;
import paulinastapor.booky.roles.Role;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @NotNull
    @Column(unique = true)
    private Integer userNumber;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToMany
    @JoinTable(name = "user_role")
    private Set <Role> roles;


}
