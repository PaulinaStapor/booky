package paulinastapor.booky.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paulinastapor.booky.books.BookRepository;
import paulinastapor.booky.roles.Role;
import paulinastapor.booky.roles.RoleRepository;

import java.util.HashSet;

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
        User user = userDtoToUserEntityMapper.rewriteUserDtoToUser(userDto);
        Role userRole = roleRepository.findRoleByRoleName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role(Role.ROLE_USER);
            roleRepository.save(userRole);
        }
        user.setRoles(new HashSet<>());
        user.getRoles().add(userRole);

        userRepository.save(user);
    }
}
