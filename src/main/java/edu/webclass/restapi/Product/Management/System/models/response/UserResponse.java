package edu.webclass.restapi.Product.Management.System.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.webclass.restapi.Product.Management.System.models.enums.UserState;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long userId;
    private String name;
    private String email;
    private UserState active;
    private String message;
    private boolean success;

    public UserResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
