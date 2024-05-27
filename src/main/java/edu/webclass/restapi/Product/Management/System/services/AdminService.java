package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.webclass.restapi.Product.Management.System.models.entity.User;
import edu.webclass.restapi.Product.Management.System.models.enums.UserState;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AdminService {
    ////////////////////////////////???????????
    private final UserRepository userRepository;
    public ResponseEntity<?> setActiveStatus(String username, boolean active) {
        User user = userRepository.findByName(username);
        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }
        user.setActive(active ? UserState.ACTIVE : UserState.INACTIVE);
        userRepository.save(user);
        return ResponseEntity.ok().body("User " + username + " " + (active ? "activated" : "deactivated"));
    }
    public ResponseEntity<?> listUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
