package edu.webclass.restapi.Product.Management.System.controllers;
import edu.webclass.restapi.Product.Management.System.models.enums.UserState;
import edu.webclass.restapi.Product.Management.System.models.request.LoginRequest;
import edu.webclass.restapi.Product.Management.System.models.request.RegisterRequest;
import edu.webclass.restapi.Product.Management.System.models.response.UserResponse;
import edu.webclass.restapi.Product.Management.System.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest request) {
        try {
            UserResponse newUser = userService.registerUser(request);
            if (newUser.isSuccess()) {
                return ResponseEntity.ok(newUser);
            } else {
                return ResponseEntity.badRequest().body(newUser); // Improved context for bad requests
            }
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(new UserResponse(null, null, null, UserState.INACTIVE, e.getMessage(), false));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new UserResponse(null, null, null, UserState.INACTIVE, "An internal error occurred during registration.", false));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody LoginRequest request) {
        try {
            UserResponse userResponse = userService.loginUser(request);
            if (userResponse.isSuccess()) {
                return ResponseEntity.ok(userResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userResponse); // More appropriate HTTP status
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new UserResponse(null, null, null, UserState.INACTIVE, "An internal error occurred during login.", false));
        }
    }
}
