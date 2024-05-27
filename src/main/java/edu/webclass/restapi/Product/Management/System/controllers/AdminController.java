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
    private AdminService adminService;//http://file/1234 path variable
    @PutMapping("/users")
    public ResponseEntity<String> setActiveStatus(@RequestParam("username") String username,
                                             @RequestParam("active") boolean active) {
        return adminService.setActiveStatus(username, active);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> listUsers() {
        List<User> users = adminService.listUsers();
        return ResponseEntity.ok(users);
    }
}
