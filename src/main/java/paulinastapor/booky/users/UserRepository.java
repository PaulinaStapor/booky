package paulinastapor.booky.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    @Query("select u from User u order by u.lastName")
    List<User>getAllUsers();
    @Query("select u from User u where u.email= :email")
    User findUserByEmail (String email);
    @Query("select u from User u where u.lastName=:lastName")
    List<User> findUserByLastName(String lastName);
}
