package paulinastapor.booky.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import paulinastapor.booky.users.exception.UserExistException;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private UserRepository userRepository;
    private UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping(value = "/index")
    public String homePage() {
        return "index";

    }

    @GetMapping(value = "/register")
    public String registration(Model model) {
        model.addAttribute("registerForm", new UserDto());
        return "registrationForm";
    }

    @PostMapping(value = "/register")
    public String registration(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registrationForm";
        }
        try {
            userService.registerUser(userDto);
        } catch (UserExistException e) {
            bindingResult.rejectValue("email", "user.exists", "User already exists.");
            return "registrationForm";
        }
        return "registrationResult";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "loginForm";
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        model.addAttribute("userList", userRepository.getAllUsers());
        return "users";
    }

    @GetMapping(value = "/findusers")
    public String findUsers(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("queryValue", query);
        List<User> users = userRepository.findUserByLastName(query);
        model.addAttribute("userList", users);
        return "users";
    }
}
