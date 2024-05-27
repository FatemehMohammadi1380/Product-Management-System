package edu.webclass.restapi.Product.Management.System.controllers;

import edu.webclass.restapi.Product.Management.System.models.entity.User;
import edu.webclass.restapi.Product.Management.System.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PutMapping("/users?username={username}&active={active}") ///////???????
    public ResponseEntity<?> setActiveStatus(@PathVariable String username, @PathVariable boolean active) {
        return adminService.setActiveStatus(username, active);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = (List<User>) adminService.listUsers();
        return ResponseEntity.ok(users);
    }
}
