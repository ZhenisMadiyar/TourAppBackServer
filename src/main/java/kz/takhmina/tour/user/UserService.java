package kz.takhmina.tour.user;

import kz.takhmina.tour.exception.UserAlreadyExistException;
import kz.takhmina.tour.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String email, String psw) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found"));
        if (user.getPassword().equals(psw)) {
            return user;
        } else {
            throw new IllegalStateException("Incorrect user or password");
        }
    }

    public User registerUser(User user) throws UserAlreadyExistException {
        if (user.getPassword() != null &&
                user.getName() != null &&
                user.getEmail() != null &&
                user.getPhoneNumber() != null) {
            if (checkIfUserExist(user.getEmail())) {
                throw new UserAlreadyExistException("User already exists for this email");
            }
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistException("Fill in all the fields");
        }
    }

    public boolean checkIfUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

}
