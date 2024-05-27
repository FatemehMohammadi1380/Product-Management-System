// UserService.java
package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.models.entity.User;
import edu.webclass.restapi.Product.Management.System.models.enums.UserState;
import edu.webclass.restapi.Product.Management.System.models.request.LoginRequest;
import edu.webclass.restapi.Product.Management.System.models.request.RegisterRequest;
import edu.webclass.restapi.Product.Management.System.models.response.UserResponse;
import edu.webclass.restapi.Product.Management.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserService {
    //@Autowired
    private final UserRepository userRepository;

    public UserResponse registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new UserResponse(null, null, null, UserState.INACTIVE, "Email already in use.", false);
        }

        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword()); // Consider using a password encoder here
        newUser.setActive(UserState.INACTIVE); // User should be inactive initially if you follow some email verification steps

        newUser = userRepository.save(newUser);
        return new UserResponse(
                newUser.getId(),
                newUser.getName(),
                newUser.getEmail(),
                newUser.getActive(),
                "User registration successful.",
                true
        );
    }

    public UserResponse loginUser(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null) {
            return new UserResponse(null, null, null, UserState.INACTIVE, "User not found.", false);
        }

        if (!request.getPassword().equals(user.getPassword())) { // Password should be checked with a password encoder
            return new UserResponse(null, null, null, UserState.INACTIVE, "Invalid password.", false);
        }

        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getActive(),
                "Login successful.",
                true
        );
    }
}
