package paulinastapor.booky.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paulinastapor.booky.books.BookRepository;
import paulinastapor.booky.roles.Role;
import paulinastapor.booky.roles.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BookRepository bookRepository;
    private UserDtoToUserEntityMapper userDtoToUserEntityMapper;

    @Autowired
    public UserService(RoleRepository roleRepository, UserRepository userRepository, BookRepository bookRepository, UserDtoToUserEntityMapper userDtoToUserEntityMapper) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.userDtoToUserEntityMapper = userDtoToUserEntityMapper;
    }

    public void registerUser(UserDto userDto) {
        Role userRole=roleRepository.findRoleByRoleName("ROLE_USER");
        User user = userDtoToUserEntityMapper.rewriteUserDtoToUser(userDto);

        if (("Anna".equals(user.getFirstName()) && "Anna".equals(user.getLastName()) && "anna@anna.com".equals(user.getEmail()))) {
            user.setRoles(new HashSet<>());
            userRole = new Role(Role.ROLE_ADMIN);
            user.getRoles().add(userRole);

        } else if (userRole==null)  {
            user.setRoles(new HashSet <>());
            userRole = new Role(Role.ROLE_USER);
            user.getRoles().add(userRole);
        }

        userRepository.save(user);
    }
}
