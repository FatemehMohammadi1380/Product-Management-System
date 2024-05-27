package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.webclass.restapi.Product.Management.System.models.entity.User;
import edu.webclass.restapi.Product.Management.System.models.enums.UserState;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class AdminService {
    private final UserRepository userRepository;

    public ResponseEntity<String> setActiveStatus(String username, boolean active) {
        Optional<User> optionalUser = userRepository.findByName(username);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found");
        }
        User user = optionalUser.get();
        user.setActive(active ? UserState.ACTIVE : UserState.INACTIVE);
        userRepository.save(user);
        return ResponseEntity.ok().body("User " + username + " " + (active ? "activated" : "deactivated"));
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
