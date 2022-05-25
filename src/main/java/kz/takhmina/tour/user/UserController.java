package kz.takhmina.tour.user;

import kz.takhmina.tour.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public User loginUser(@RequestParam String user_email, @RequestParam String user_psw) {
        return userService.getUser(user_email, user_psw);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws UserAlreadyExistException {
        return userService.registerUser(user);
    }
}
