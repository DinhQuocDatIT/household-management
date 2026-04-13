package dinhquocdat.backend.dto.request;


import dinhquocdat.backend.entity.Role;
import lombok.Data;

@Data
public class UpdateUserRequest {
    private String password;
    private Role role;
}