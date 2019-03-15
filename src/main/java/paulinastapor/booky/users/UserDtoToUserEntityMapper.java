package paulinastapor.booky.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDtoToUserEntityMapper {
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserDtoToUserEntityMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User rewriteUserDtoToUser(UserDto userDto) {

        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserNumber(userDto.getUserNumber());
        user.setEmail(userDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        return user;
    }

}
