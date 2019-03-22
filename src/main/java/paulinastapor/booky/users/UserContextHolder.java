package paulinastapor.booky.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class UserContextHolder {
    private UserRepository userRepository;
@Autowired
    public UserContextHolder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }
        User user=userRepository.findUserByEmail(authentication.getName());


        return "Hello " +user.getFirstName() + "!";
    }

}
